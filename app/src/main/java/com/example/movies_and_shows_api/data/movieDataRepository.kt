package com.example.movies_and_shows_api.data

import com.example.movies_and_shows_api.data.remote.MoviesRemoteDataSource
import com.example.movies_and_shows_api.data.remote.api.moviesApiRemoteDataSource


class SuperHeroDataRepository(
    val remoteSource: MoviesRemoteDataSource
)