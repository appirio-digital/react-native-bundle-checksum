
# react-native-bundle-checksum

## Getting started

`$ npm install react-native-bundle-checksum --save`

### Mostly automatic installation

`$ react-native link react-native-bundle-checksum`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-bundle-checksum` and add `RNBundleChecksum.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBundleChecksum.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBundleChecksumPackage;` to the imports at the top of the file
  - Add `new RNBundleChecksumPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-bundle-checksum'
  	project(':react-native-bundle-checksum').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-bundle-checksum/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-bundle-checksum')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNBundleChecksum.sln` in `node_modules/react-native-bundle-checksum/windows/RNBundleChecksum.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Bundle.Checksum.RNBundleChecksum;` to the usings at the top of the file
  - Add `new RNBundleChecksumPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNBundleChecksum from 'react-native-bundle-checksum';

// TODO: What to do with the module?
RNBundleChecksum;
```
  