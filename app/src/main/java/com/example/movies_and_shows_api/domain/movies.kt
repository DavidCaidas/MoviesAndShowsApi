package com.example.movies_and_shows_api.domain

data class movie( val id: String,
                   val title:String,
                   val plot:String,
                   val genre:String,
                   val rating:Double,
                   val year:Int,
                   val Poster:String )

