package com.example.androiddaggerhilt.demo

import android.util.Log
import javax.inject.Inject

class Engine {

    @Inject
    constructor()
    fun getEngine(){
        Log.e("Main", "Engine is started..")
    }

}