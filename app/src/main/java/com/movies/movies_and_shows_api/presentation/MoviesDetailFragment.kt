package com.movies.movies_and_shows_api.presentation.adapter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.movies_and_shows_api.databinding.FragmentMoviesDetailBinding
import com.movies.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.movies.movies_and_shows_api.extensions.loadUrl
import com.movies.movies_and_shows_api.presentation.MovieFactory
import com.movies.movies_and_shows_api.presentation.MoviesDetailViewModel

class MovieDetailFragment : Fragment() {
    private var viewModel: MoviesDetailViewModel? = null
    private var binding: FragmentMoviesDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = MovieFactory().getMoviesDetailViewModel(requireContext())
        setupObservers()
        arguments?.getString("movieId")?.let { viewModel!!.loadDetailMovie(it) }
    }

    private fun setupObservers() {
        val movieDetailsState = Observer<MoviesDetailViewModel.MovieDetailState> { state ->
            state.movieDetail?.let {
                bind(it)
            }
        }
        viewModel?.movieDetailState?.observe(viewLifecycleOwner, movieDetailsState)
    }

    private fun bind(model: GetMovieDetailUseCase.movieDetail) {
        binding?.apply {
            MovieTitledetail.text = model.title
            MovieGenredetail.text = model.genre
            MoviePlotdetail.text = model.plot
            MovieYeardetail.text = model.year
            MovieRatingdetail.text = model.rating
            MoviePosterdetail.loadUrl(model.poster)
        }
    }

}