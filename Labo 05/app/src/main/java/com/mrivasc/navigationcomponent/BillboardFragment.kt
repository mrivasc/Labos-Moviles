package com.mrivasc.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var buttonAddMovie : FloatingActionButton
    private lateinit var movieCard : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonAddMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_addMovieFragment)
        }

        movieCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieInfoFragment)
        }
    }

    private fun bind() {
        buttonAddMovie = view?.findViewById(R.id.btn_addMovie) as FloatingActionButton
        movieCard = view?.findViewById(R.id.cardView_starWarsMovieInfo) as CardView
    }
}