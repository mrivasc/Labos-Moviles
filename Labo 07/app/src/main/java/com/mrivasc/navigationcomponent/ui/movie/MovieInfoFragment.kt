package com.mrivasc.navigationcomponent.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrivasc.navigationcomponent.R
import com.mrivasc.navigationcomponent.databinding.FragmentMovieInfoBinding

class MovieInfoFragment : Fragment() {

    private lateinit var binding : FragmentMovieInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}