package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.ScheduleViewModel
import com.example.sdu_portal_mobile.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {

    private lateinit var binding: FragmentScheduleBinding

    private val viewModel: ScheduleViewModel by viewModels()

    var names =
        arrayOf(
            "9:00 10:00",
            "10:00 11:00",
            "11:00 12:00",
            "12:00 13:00",
            "13:00 14:00",
            "14:00 15:00",
            "15:00 16:00",
            "16:00 17:00",
            "17:00 18:00"
        )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(layoutInflater)
        val view = binding.root

        binding.ScheduleRecyclerView.layoutManager = LinearLayoutManager(this.context)

        binding.ScheduleRecyclerView.adapter = ListAdapter(names)


        binding.imageVectorBack.setOnClickListener { onLeftClicked() }
        binding.imageVectorForward.setOnClickListener { onRightClicked() }

        viewModel.currentWeekDay.observe(viewLifecycleOwner) { newWord ->
            binding.nameOfDay.text = newWord
        }

//        binding.addScheduleButton.setOnClickListener{ view ->
//            view.findNavController().navigate(R.id.action_scheduleFragment_to_createScheduleFragment)
//        }
        return view
    }

    private fun onLeftClicked()=viewModel.setPreviousWeekDay()

    private fun onRightClicked()=viewModel.setNextWeekDay()

}