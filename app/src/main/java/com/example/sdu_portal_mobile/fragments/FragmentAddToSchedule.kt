package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentAddToScheduleBinding
import com.example.sdu_portal_mobile.databinding.FragmentScheduleBinding
import com.example.sdu_portal_mobile.viewModels.AddToScheduleViewModel
import java.util.*

class FragmentAddToSchedule: Fragment() {
    private val viewModel: AddToScheduleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddToScheduleBinding.inflate(inflater)
        val binding2 = FragmentScheduleBinding.inflate(inflater)

        viewModel.data.observe(viewLifecycleOwner){
            binding2.ScheduleRecyclerView.adapter = ListAdapter(it)
        }
        binding.submitScheduleButton.setOnClickListener{view: View ->
            viewModel.addLessonToSchedule(LoginFragment.getSduId(), ScheduleFragment.dayOfTheWeek, binding.timeSpinner.selectedItem.toString(),
            binding.codes.selectedItem.toString(), "Algebra", "G403")
            view.findNavController().navigate(R.id.action_fragmentAddToSchedule_to_scheduleFragment)
        }
        return binding.root
    }
}