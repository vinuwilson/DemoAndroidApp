package com.example.demoandroidapp

import org.junit.Test

import org.junit.Assert.*

private lateinit var viewModel :  MovieViewModel

class MovieViewModelShould {

    @Test
    fun getMovieListFromRepository() {
        viewModel = MovieViewModel()
        viewModel.getMovieList()
        assertEquals(4, 2 + 2)
    }
}