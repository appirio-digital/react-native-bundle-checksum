
Pod::Spec.new do |s|
  s.name         = "RNBundleChecksum"
  s.version      = "1.0.0"
  s.summary      = "RNBundleChecksum"
  s.description  = <<-DESC
                  RNBundleChecksum
                   DESC
  s.homepage     = "https://github.com/appirio-digital/react-native-bundle-checksum"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/appirio-digital/react-native-bundle-checksum.git", :tag => "master" }
  s.source_files  = "RNBundleChecksum/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  
