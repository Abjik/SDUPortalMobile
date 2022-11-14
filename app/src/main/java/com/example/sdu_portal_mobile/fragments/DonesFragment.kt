package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentDonesBinding

class DonesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDonesBinding.inflate(inflater)

        binding.buttonTODO.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_donesFragment2_to_todosFragment)
        }

        return binding.root
    }
}