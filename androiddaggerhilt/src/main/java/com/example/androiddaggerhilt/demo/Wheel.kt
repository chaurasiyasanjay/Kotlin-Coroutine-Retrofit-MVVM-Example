package com.example.androiddaggerhilt.demo

import android.util.Log
import javax.inject.Inject

class Wheel {

    @Inject
    constructor()
    fun getWheel(){
        Log.e("Main", "Wheel is started..")
    }

}