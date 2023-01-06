package com.bignerdranch.android.moviesapp.data.models

data class Movies(
    val code: Int,
    val message: String,
    val name: String,
    val previous: Previous,
    val status: Int
)