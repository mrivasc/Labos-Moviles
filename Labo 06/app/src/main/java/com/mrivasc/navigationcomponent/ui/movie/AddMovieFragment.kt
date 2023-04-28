package com.mrivasc.navigationcomponent.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mrivasc.navigationcomponent.R
import com.mrivasc.navigationcomponent.data.model.MovieModel

class AddMovieFragment : Fragment() {
    private lateinit var btn_submit : Button

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        btn_submit.setOnClickListener {
            var name = nameEditText.text.toString()
            var category = categoryEditText.text.toString()
            var description = descriptionEditText.text.toString()
            var qualification = qualificationEditText.text.toString()

            var movie: MovieModel = MovieModel( name, category, description, qualification )

            // Adding movie with movieViewModel
            movieViewModel.addMovies(movie)

            var showMovies = movieViewModel.getMovies()
            println(showMovies)
        }
    }

    private fun bind() {
        btn_submit = view?.findViewById(R.id.btn_submitButton) as Button
        nameEditText = view?.findViewById(R.id.input_name) as EditText
        categoryEditText = view?.findViewById(R.id.input_category) as EditText
        descriptionEditText = view?.findViewById(R.id.input_description) as EditText
        qualificationEditText = view?.findViewById(R.id.input_calification) as EditText
    }
}