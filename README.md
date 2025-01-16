# Kotlin OpenCV RTMP

This project demonstrates how to capture video from the camera using **Kotlin** and **OpenCV**, and then stream the video to an **RTMP server**. It integrates OpenCV for video capture and processing, and can send the processed video stream to a remote RTMP server.

## Features

- **Video Capture**: Captures video from the camera using OpenCV.
- **Video Processing**: Processes the video stream (e.g., applying filters, transformations, etc.).
- **RTMP Streaming**: Sends the processed video stream to an RTMP server.
- **Kotlin-based**: The app is written in Kotlin for Android development.

## Requirements

- Android Studio 4.0 or higher
- Android device with camera access
- OpenCV SDK (integrated into the project)
- RTMP server (for testing video stream)

## Installation and Setup

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/xinli7572/kotlin_opencv_rtmp.git
```


### 2. Open the Project in Android Studio

- Open Android Studio.
- Select **Open an existing project**.
- Navigate to the cloned repository and open it.

### 3. Add Permissions

Make sure to request the necessary permissions for camera and network access. Add the following lines to your `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```
### 4. Configure RTMP URL

Set the RTMP server URL in the `MainActivity.kt` file where the video stream will be sent:

```kotlin
val rtmpUrl = "rtmp://your.server.url/live/streamKey"

```
### 5. Build and Run
-  Connect your Android device or use an emulator that has camera access.
-  In Android Studio, select the target device.
-  Click Run or use the shortcut Shift + F10 to build and install the app on the device.
Once the app is launched, it will start capturing video from the camera, process the video, and stream it to the RTMP server.


## code Overview
### MainActivity
MainActivity is the entry point of the app, responsible for:

- Initializing the camera for video capture (using OpenCV).
- Capturing frames from the camera and applying any video processing (e.g., filters).
- Sending the processed video frames to the RTMP server.

### OpenCV Integration
The project uses the OpenCV Android SDK to access the camera and perform image processing. You can apply various OpenCV operations on the captured frames after they are received.
  1. armeabi-v7a, based on OpenCV + Android.
  2. libvideo_play.so, JNI-implemented playback code.

	```
	ndk {
	    abiFilters.add("armeabi-v7a")
	}

 	sourceSets.all {
	    jniLibs.srcDirs("libs")
	}

### RTMP Streaming
The app uses an RTMP client to stream the processed video to the specified RTMP server. The video is streamed through the RTMP URL configured in the code.

### Customization
Modify Video Processing
To customize the video processing, modify the processFrame function in MainActivity.kt. You can apply OpenCV operations such as edge detection, filters, etc., to the captured frames.

### Use a Different RTMP Server
You can use any RTMP server for testing. Popular options include YouTube, Twitch, or your own RTMP server.

Simply replace the RTMP URL in MainActivity.kt with your own server URL:

```kotlin
val rtmpUrl = "rtmp://your.server.url/live/streamKey"
```

### Technologies Used
- Kotlin: The primary programming language for Android development.
- OpenCV: A computer vision library used for video capture and processing.
- RTMP Streaming: A protocol for streaming video to servers like YouTube, Twitch, etc.
Contributions
Feel free to fork this repository and contribute to the project! You can:

### Fix bugs or improve performance.
- Add new features or enhancements.
- Improve documentation or the user interface.
