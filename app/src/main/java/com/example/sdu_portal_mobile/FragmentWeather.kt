package com.example.sdu_portal_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.databinding.FragmentDonesBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentWeather : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentDonesBinding.inflate(inflater)


        return binding.root
    }




}