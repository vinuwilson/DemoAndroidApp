package com.example.demoandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieFragment : Fragment() {

    lateinit var viewModel: MovieViewModel
    lateinit var viewModelFactory: MovieViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        setUpViewModel()
        viewModel.movieList.observe(this as LifecycleOwner){ movieList ->
            if(movieList.getOrNull() != null)
                setupList(view, movieList.getOrNull()!!)
            else
                TODO()
        }
        return view
    }

    private fun setupList(view: View?, movieList: MovieList) {
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)

            adapter = MovieListRecyclerViewAdapter(movieList)
        }
    }

    private fun setUpViewModel() {
        viewModelFactory = MovieViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
    }

    companion object {

        @JvmStatic
        fun newInstance() = MovieFragment().apply { }
    }
}