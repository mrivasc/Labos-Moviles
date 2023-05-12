package com.mrivasc.navigationcomponent.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mrivasc.navigationcomponent.R
import com.mrivasc.navigationcomponent.data.model.MovieModel
import com.mrivasc.navigationcomponent.databinding.FragmentBillboardBinding
import com.mrivasc.navigationcomponent.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter

class BillboardFragment : Fragment() {

    // Elements
    private lateinit var buttonAddMovie : FloatingActionButton
    //private lateinit var movieCard : CardView
    private lateinit var binding : FragmentBillboardBinding

    // Adapter
    private lateinit var adapter: MovieRecyclerViewAdapter

    // ViewModel
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        /*buttonAddMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_addMovieFragment)
        }

        movieCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieInfoFragment)
        }*/

        setRecyclerView(view)

        binding.btnAddMovie.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_addMovieFragment)
        }
    }

    private fun showSelectedItems(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieInfoFragment)
    }

    private fun displayMovies() {
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItems(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun bind() {
        buttonAddMovie = view?.findViewById(R.id.btn_addMovie) as FloatingActionButton
        //movieCard = view?.findViewById(R.id.cardView_starWarsMovieInfo) as CardView
    }
}