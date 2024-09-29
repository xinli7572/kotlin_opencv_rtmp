package com.example.kotlin_opencv_rtmp

import android.app.Activity
import android.content.SharedPreferences
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.videolibrary.VideoPresenter

lateinit var start_video: Button
lateinit var end_video: Button
lateinit var address_camera_text: EditText

lateinit var imageView: ImageView
private var mBitmap: Bitmap? = null

lateinit var sharedPreferences: SharedPreferences
lateinit var editor: SharedPreferences.Editor

private val WIDTH = 720
private val HEIGHT = 640

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.img_msg)

        start_video = findViewById<Button>(R.id.start_video)
        end_video = findViewById<Button>(R.id.end_video)

        address_camera_text = findViewById<EditText>(R.id.address_camera)
        address_camera_text.inputType = InputType.TYPE_TEXT_VARIATION_URI

        start_video.setOnClickListener {
            start_video()
        }

        end_video.setOnClickListener {
            stop_video()
        }

        //================================================
        //save data
        //================================================
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        var camera_text: String? = sharedPreferences.getString("address_camera_text", "")
        address_camera_text.text = Editable.Factory.getInstance().newEditable(camera_text)
    }

    fun start_video() {
        Toast.makeText(
            applicationContext,
            "正在加载...", Toast.LENGTH_LONG
        ).show()

        initView()
        regVideoCallback()
    }

    fun stop_video() {
        VideoPresenter.getInstance()!!.stopReadVideo()
    }

    private fun initView() {
        editor.putString("address_camera_text",address_camera_text.text.toString())
        editor.commit()

        VideoPresenter.getInstance()
            ?.startReadVideo(address_camera_text.text.toString(), 4, 2, WIDTH, HEIGHT)
    }

    fun regVideoCallback() {
        mBitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_4444)
        VideoPresenter.getInstance()!!.regVideoCallback(object : VideoPresenter.IVideoCallback {
            override fun onImageShow() {
                showImage()
            }
        }, mBitmap!!)
    }

    private fun showImage() {
        runOnUiThread {
            if (mBitmap != null) {
                imageView.setImageBitmap(mBitmap)
            }
        }
    }
}