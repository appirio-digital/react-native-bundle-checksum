using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Bundle.Checksum.RNBundleChecksum
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNBundleChecksumModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNBundleChecksumModule"/>.
        /// </summary>
        internal RNBundleChecksumModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNBundleChecksum";
            }
        }
    }
}
