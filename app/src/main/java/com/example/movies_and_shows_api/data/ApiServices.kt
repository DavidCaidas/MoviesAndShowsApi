package com.iesam.superhero.data

import com.example.movies_and_shows_api.data.remote.api.moviesApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints o Servicios para SuperHeros
 */
interface ApiServices {
    @GET("all.json")
    fun getmoviesFeed(): Call<List<moviesApiModel>>

    @GET("id/{heroId}.json")
    fun getmovie(@Path("movieId") movieId: String): Call<moviesApiModel>

}
