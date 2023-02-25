package com.example.demoandroidapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel :ViewModel() {


    val movieList = MutableLiveData<Result<MovieList>>()

    fun getMovieList() {
        TODO("Not yet implemented")
    }
}