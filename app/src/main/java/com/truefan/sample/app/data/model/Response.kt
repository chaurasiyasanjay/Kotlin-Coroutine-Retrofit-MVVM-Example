package com.truefan.sample.app.data.model

data class Response(
    val quizFound : Boolean,
    val rank : Int,
    val score : Int,
    val msg : String
)