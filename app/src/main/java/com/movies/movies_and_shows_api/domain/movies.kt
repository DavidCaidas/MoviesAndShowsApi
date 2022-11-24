package com.movies.movies_and_shows_api.domain

data class Movie( val id: String,
                   val title:String,
                   val plot:String,
                   val genre:String,
                   val rating:String,
                   val year:String,
                   val poster:String )

