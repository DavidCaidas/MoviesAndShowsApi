package com.iesam.superhero.data

import com.example.movies_and_shows_api.data.remote.api.moviesApiModel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val baseEndPoints: String =
        "https://movies-and-shows-api.cyclic.app/movies"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoints)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getmovies(): List<moviesApiModel> {
        val movies = apiServices.getmoviesFeed()
        val response = movies.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getmovie(movieId: String): moviesApiModel? {
        val call = apiServices.getmovie(movieId).execute()
        return call.body()
    }


}