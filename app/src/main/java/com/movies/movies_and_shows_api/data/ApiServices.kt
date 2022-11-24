
package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.remote.api.moviesApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServices {
    @GET("movies")
    fun getMovies(): Call<List<MoviesApiModel>>

    @GET("id/{movieId}")
    fun getMovie(@Path("movieId") movieId: String): Call<MoviesApiModel>
}

