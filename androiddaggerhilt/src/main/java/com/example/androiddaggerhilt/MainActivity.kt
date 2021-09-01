package com.example.androiddaggerhilt

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.androiddaggerhilt.ViewModel.PostViewModel
import com.example.androiddaggerhilt.demo.Car
import com.example.androiddaggerhilt.demo.Main
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var car: Car
//
//    @Inject
//    lateinit var main: Main

    private var txtView: TextView? = null
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtView = findViewById<TextView>(R.id.txt)
//        car.getCar()
//        main.getName()
        observeData()
    }

    private fun observeData() {
        postViewModel.response.observe(this, Observer { res ->
            Log.e("main", res.get(0).body)
            txtView?.text = res[0].body
        })
    }
}