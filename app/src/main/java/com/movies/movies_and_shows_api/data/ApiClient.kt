package com.movies.movies_and_shows_api.data

import ApiServices
import com.movies.movies_and_shows_api.data.remote.api.MoviesApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val baseEndPoints: String = "https://movies-and-shows-api.cyclic.app/movies"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() =
        Retrofit.Builder().baseUrl(baseEndPoints).addConverterFactory(GsonConverterFactory.create())
            .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getMovies(): List<MoviesApiModel> {
        val Movies = apiServices.getMovies()
        val response = Movies.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getMovie(movieId: String): MoviesApiModel? {
        val call = apiServices.getMovie(movieId).execute()
        return call.body()
    }


}