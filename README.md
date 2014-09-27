# C/C++ in Android Apps Workshop

Branch *master* contains solutions to all of the exercises. If you want to get the unsolved version please checkout *unsolved* branch.

You can import those projects using Eclipse as *Existing Android Code into Workspace*.

We will be using a certain set of tools that are provided in the list below. It's necessary for everyone to have a proper set-up (tested on Windows 7 64-bit but it should work fine on Linux and probably on Mac OS X too).

## 1. JDK 7
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html

## 2. Eclipse
Available at https://www.eclipse.org/downloads/packages/release/Kepler/SR2
(if you get an 'Execution over HTTP is unsupported.' error message make sure to change the URL so it starts with 'https://')

## 3. Android SDK
https://developer.android.com/sdk/index.html
There's a bundle that contains both Eclipse and the SDK but is currently broken so we prefer to install them separately.
Press the 'Get the SDK for an existing IDE' button and download the standalone SDK installer. Run it and install the SDK (e.g. in C:\android-sdk)

## 4. Android NDK
Available at https://developer.android.com/tools/sdk/ndk/index.html#Downloads. Please select the 32-bit target platform and extract it (e.g. in C:\android-ndk-r10b).

## 5. Environment variables
Make sure to set those environment variables so they point to the installation directories of the above programs, e.g.

ANDROID_NDK=C:\android-ndk-r10b

ANDROID_HOME=C:\adt-bundle\sdk

add to your PATH (Windows): "%ANDROID_NDK%;%ANDROID_HOME%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools"

add to your PATH (*nix):
"${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${ANDROID_NDK}"

## 6. Configure paths to the SDK and NDK
Run Eclipse and set paths to Android SDK and NDK in
Window > Preferences > Android
Window > Preferences > Android > NDK

## 7. ADT 23.0.3 plugin for Eclipse
http://developer.android.com/sdk/installing/installing-adt.html

## 8. CDT plugin for Eclipse
In the same page as with ADT select --All Available Sites-- and search for C++. Select C/C++ Development Tools and install.

## 9. Install additional packages for the SDK
http://developer.android.com/sdk/installing/adding-packages.html
Download Android Platform-Tools, Android Build-Tools and at least whole section of the API19.

## 10. Debuggable device
Make sure your device is debuggable via USB by installing proper drivers (on Windows). You can check your connected devices in the DDMS perspective of Eclipse.

