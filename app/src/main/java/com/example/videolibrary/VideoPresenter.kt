package com.example.videolibrary

import android.graphics.Bitmap

class VideoPresenter {

    val TAG = "video_play"


    init {
        System.loadLibrary("video_play");
    }

    companion object {
        private var mInstance: VideoPresenter? = null
        fun getInstance(): VideoPresenter? {
            if (mInstance == null) {
                synchronized(VideoPresenter::class.java) {
                    if (mInstance == null) {
                        System.loadLibrary("video_play");
                        mInstance = VideoPresenter()
                    }
                }
            }
            return mInstance
        }
    }

    fun startReadVideo(videoPath: String, showFps: Int, lostFps: Int, width: Int, height: Int) {
        nativeStartReadVideo(videoPath, showFps, lostFps, width, height)
    }


    fun stopReadVideo() {
        nativeStopReadVideo()
    }


    fun regVideoCallback(videoCallback: IVideoCallback, bitmap: Bitmap) {
        nativeRegVideoCallback(videoCallback, bitmap)
    }


    interface IVideoCallback {
        fun onImageShow()
    }


    private external fun nativeRegVideoCallback(videoCallback: IVideoCallback, bitmap: Bitmap)

    private external fun nativeStartReadVideo(
        videoPath: String,
        showFps: Int,
        lostFps: Int,
        width: Int,
        height: Int
    )

    private external fun nativeStopReadVideo()
}