package com.movies.movies_and_shows_api.presentation.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_and_shows_api.databinding.FragmentMoviesDetailBinding
import com.movies.movies_and_shows_api.extensions.loadUrl
import com.movies.movies_and_shows_api.domain.GetMovieDetailUseCase

class MovieDetailViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(
    view
){
    fun bind (movie : GetMovieDetailUseCase.movieDetail) {
        val binding = FragmentMoviesDetailBinding.bind(view)
        binding.MovieTitledetail.text = movie.title
        binding.MovieGenredetail.text = movie.genre
        binding.MovieRatingdetail.text = movie.rating.toString()
        binding.MoviePlotdetail.text = movie.plot
        binding.MovieYeardetail.text = movie.year
        binding.MoviePosterdetail.loadUrl(movie.poster)

    }
}