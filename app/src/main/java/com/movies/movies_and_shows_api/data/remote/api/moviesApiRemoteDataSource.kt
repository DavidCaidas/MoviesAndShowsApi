package com.movies.movies_and_shows_api.data.remote.api


import com.movies.movies_and_shows_api.data.remote.MoviesRemoteDataSource
import com.movies.movies_and_shows_api.domain.Movie
import com.movies.movies_and_shows_api.data.ApiClient

class MoviesApiRemoteDataSource(val apiClient: ApiClient) : MoviesRemoteDataSource {

    override fun getMovies(): List<Movie> {
        val movies = apiClient.getMovies()
        return movies.map {
            it.toDomain()
        }
    }

    override fun getMovie(movieId: String): Movie? {
        return apiClient.getMovie(movieId)?.toDomain()
    }
}