package com.movies.movies_and_shows_api.presentation


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies_and_shows_api.databinding.FragmentMoviesFeedBinding
import com.movies.movies_and_shows_api.commons.KSerializer
import com.movies.movies_and_shows_api.presentation.adapter.MovieAdapter




class MovieFeedFragment: Fragment() {

    private var binding: FragmentMoviesFeedBinding? = null
    private val movieAdapter = MovieAdapter()
    private val viewModel by lazy {
        MovieFactory().getMoviesFeedViewModel(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesFeedBinding.inflate(inflater)
        setupView()
        return binding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadMovies()
    }


    private fun setupView() {
        binding?.apply {
            feedListRecyclerView.apply {
                adapter = movieAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
/*
                MovieAdapter.setItemClick {
                    navigateToMovieDetail(it)
                }
                */
            }

        }
    }

    private fun setupObservers() {
        val moviesFeedSuscriber =
            Observer<MoviesFeedViewModel.MoviesUiState> { uiState ->
                movieAdapter.setDataItems(uiState.moviesFeed)
            }
        viewModel.moviesFeedPublisher.observe(viewLifecycleOwner, moviesFeedSuscriber)
    }

    private fun navigateToDetail(movieId: String) {
        findNavController().navigate(MovieFeedFragmentDirections.actionMovieFeedToMovieDetail(movieId))
    }
}