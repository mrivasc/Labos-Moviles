package com.mrivasc.navigationcomponent.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mrivasc.navigationcomponent.R
import com.mrivasc.navigationcomponent.databinding.FragmentBillboardBinding

class BillboardFragment : Fragment() {

    private lateinit var buttonAddMovie : FloatingActionButton
    private lateinit var movieCard : CardView
    private lateinit var binding : FragmentBillboardBinding

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