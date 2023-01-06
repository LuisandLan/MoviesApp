package com.bignerdranch.android.moviesapp.data.network

import com.bignerdranch.android.moviesapp.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies():Response<List<Movies>>

}