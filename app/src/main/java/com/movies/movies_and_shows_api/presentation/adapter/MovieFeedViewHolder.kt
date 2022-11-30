package com.movies.movies_and_shows_api.presentation.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_and_shows_api.databinding.ViewItemMovieFeedBinding
import com.movies.movies_and_shows_api.extensions.loadUrl
import com.movies.movies_and_shows_api.domain.GetMoviesFeedUseCase

class MovieFeedViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(
    view
) {
    fun bind(movie: GetMoviesFeedUseCase.MovieFeed, onClick: ((String) -> Unit)?) {
        val binding = ViewItemMovieFeedBinding.bind(view)
        binding.filmTitleItem.text = movie.title
        binding.genrelabel.text = movie.genre
        binding.rating.text = movie.rating
        binding.imageItem.loadUrl(movie.poster)
        view.setOnClickListener {
            onClick?.invoke(movie.id)
        }
    }
}