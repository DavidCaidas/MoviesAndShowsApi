package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.remote.MoviesRemoteDataSource

class MoviesDataRepository(
    val remoteSource: MoviesRemoteDataSource
    /*,
    val localSource : MoviesLocalDataSource
    */
)