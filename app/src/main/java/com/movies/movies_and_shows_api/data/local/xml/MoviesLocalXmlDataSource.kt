package com.movies.movies_and_shows_api.data.local.xml

import android.content.SharedPreferences
import com.movies.movies_and_shows_api.commons.KSerializer
import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.domain.Movie

class MoviesXmlLocalDataSource (private val sharedPreferences: SharedPreferences, private val serializer:KSerializer): MoviesLocalDataSource{

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    override fun getAllMovies(): List<Movie> {
        val list = mutableListOf<Movie>()
        sharedPreferences.all.forEach {
            editor.apply {
                list.add(serializer.fromJson(it.value as String, Movie::class.java))
            }.apply()
        }
        return list
    }

    override fun getMovieById(id: String): Movie {
        return sharedPreferences.getString(id, null).let{
            serializer.fromJson(it, Movie::class.java)
        }
    }

    override fun save(list: List<Movie>) {
        list.forEach {
            editor.putString(it.id, serializer.toJson(it, Movie::class.java))
        }
        editor.apply()
    }

}