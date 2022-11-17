package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.remote.MoviesRemoteDataSource
import com.movies.movies_and_shows_api.data.remote.api.moviesApiRemoteDataSource


class SuperHeroDataRepository(
    val remoteSource: MoviesRemoteDataSource
)