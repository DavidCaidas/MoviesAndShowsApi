package com.example.movies_and_shows_api.data.remote.api


import com.example.movies_and_shows_api.data.remote.MoviesRemoteDataSource
import com.example.movies_and_shows_api.domain.movie
import com.iesam.superhero.data.ApiClient

class moviesApiRemoteDataSource(val apiClient: ApiClient) : MoviesRemoteDataSource {

    override fun getmovies(): List<movie> {
        val movies = apiClient.getmovies()
        return movies.map {
            it.toDomain()
        }
    }

    override fun getmovie(movieId: String): movie? {
        return apiClient.getmovie(movieId)?.toDomain()
    }
}