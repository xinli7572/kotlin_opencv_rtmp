# Core Video Live Streaming Player Code
 -This code implements video live stream processing using OpenCV, and ensures the video delay is less than 1 second through C++ encoding.

/libs/armeabi-v7a provides two key components:
  1：A library compiled for armeabi-v7a based on OpenCV + Android.
  2：libvideo_play.so, which contains the JNI-implemented playback code.
  
## Detailed Steps
1. Add ndk configuration in build.gradle.kts to specify the dynamic library used by Android
	```
	ndk {
	    abiFilters.add("armeabi-v7a")
	}
2. Add libs configuration in build.gradle.kts to specify the location of the dynamic libraries
	```
 	sourceSets.all {
	    jniLibs.srcDirs("libs")
	}
3. java/com/example/videolibrary/VideoPresenter.kt: Kotlin code corresponding to JNI, including the native interface.
4. java/com/example/kotlin_opencv_rtmp/MainActivity.kt: Core code that uses the JNI interface to display the video.
5. In java/com/example/kotlin_opencv_rtmp/MainActivity.kt,The entry point of the video playback code.
   ```
   start_video()
      ```
6. A callback method based on OpenCV’s C++ code. The video stream obtained via OpenCV is converted into images, and this callback method is used to display the video frames on the phone screen. 
   ```
	fun regVideoCallback()
   ```



https://github.com/user-attachments/assets/e0457739-98f4-499f-9bf1-83a507b0c462



