package com.example.fbkt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lateinit var viewModel: ScoreViewModel
//        viewModel = ViewModelProviders.of(this)[ScoreViewModel::class.java]
//
//        val text = viewModel.addScore();
//        val duration = Toast.LENGTH_SHORT
//
//        val toast = Toast.makeText(this, text, duration)
//        toast.show()
    }
}
