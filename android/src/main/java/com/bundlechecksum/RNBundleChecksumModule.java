
package com.bundlechecksum;

import android.content.res.AssetManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RNBundleChecksumModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNBundleChecksumModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBundleChecksum";
  }

  @ReactMethod
  public void getChecksum(Promise promise){
    BufferedReader br = null;
    String bundle = null;
    try {
      AssetManager assetManager = getReactApplicationContext().getAssets();
      InputStream stream = assetManager.open("index.android.bundle", 0);
      if (stream == null) {
        reject(promise, "com.bundlechecksum", new Exception("Failed to open bundle file. You may be running in development mode."));
        return;
      }

      br = BufferedReader(new InputStreamReader(stream, "UTF-8"));
      StringBuilder sb = new StringBuilder();

      String str;
      while ((str = br.read()) != null){
        sb.append(str);
      }
      br.close();

      bundle = sb.toString();
      sb = null;

      if (bundle == null || bundle.equals("")) {
        reject(promise, "com.bundlechecksum", new Exception("Failed to open bundle file. You may be running in development mode."));
        return;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      reject(promise, "com.bundlechecksum", ex);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e){
          Log.e("com.bundlechecksum", "Error closing stream.");
        }
      }
    }

    MessageDigest md = null;
    try {
        md = MessageDigest.getInstance("SHA-256");
        md.update(bundle.getBytes("UTF-8"));
        byte[] digest = md.digest();
        String hash = String.format("%064x", new java.math.BigInteger(1, digest));
        promise.resolve(hash);

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        promise.reject("com.bundlechecksum", e.getMessage());
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        promise.reject("com.bundlechecksum", e.getMessage());
    }
  }
}