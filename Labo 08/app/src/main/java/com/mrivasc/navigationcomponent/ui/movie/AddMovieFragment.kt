package com.mrivasc.navigationcomponent.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mrivasc.navigationcomponent.R
import com.mrivasc.navigationcomponent.data.model.MovieModel
import com.mrivasc.navigationcomponent.databinding.FragmentAddMovieBinding

class AddMovieFragment : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding : FragmentAddMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("ola, estoy observando el estado", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("ola, estoy observando el estado", status)
                    Log.d("ola, estoy observando el estado", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}