package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.data.remote.api.MoviesApiRemoteDataSource
import com.movies.movies_and_shows_api.domain.Movie
import com.movies.movies_and_shows_api.domain.MovieRepository

class MoviesDataRepository(
    val remoteSource: MoviesApiRemoteDataSource,
    val localSource: MoviesLocalDataSource
) :
    MovieRepository {

    override fun getMovie(): List<Movie> {
        var movies = localSource.getAllMovies()
        if (movies.isNullOrEmpty()) {
            movies = remoteSource.getMovies()
            localSource.save(movies)
            return movies
        }
        return movies
    }

    override fun getMovieById(movieId: String): Movie? {
        var movie = localSource.getMovieById(movieId)
        if (movie == null) {
            movie = remoteSource.getMovie(movieId)
            return movie
        }
        return movie
    }
}