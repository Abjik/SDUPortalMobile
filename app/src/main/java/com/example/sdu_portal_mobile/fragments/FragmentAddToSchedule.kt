package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentAddToScheduleBinding

class FragmentAddToSchedule: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddToScheduleBinding.inflate(inflater)

        binding.submitScheduleButton.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_fragmentAddToSchedule_to_scheduleFragment)
        }
        return binding.root
    }
}