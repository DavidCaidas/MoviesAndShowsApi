package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.remote.api.moviesApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServices {
    @GET("all.json")
    fun getMoviesFeed(): Call<List<moviesApiModel>>

    @GET("id/{movieId}.json")
    fun getMovie(@Path("movieId") movieId: String): Call<moviesApiModel>

}
