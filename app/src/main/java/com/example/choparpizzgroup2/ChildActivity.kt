package com.example.choparpizzgroup2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.choparpizzgroup2.model.ResultModel

class ChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)

        val getResult = intent.getParcelableExtra<ResultModel.SubMember>("fft_sb")

        getResult?.let {
            findViewById<TextView>(R.id.textView2).text = getResult.title
            findViewById<TextView>(R.id.textView3).text = getResult.description
            findViewById<ImageView>(R.id.imageView2).setImageResource(getResult.image)

        }
    }
}