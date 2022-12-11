package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.DB.Lesson
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentScheduleBinding
import com.example.sdu_portal_mobile.viewModels.ScheduleViewModel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.snapshots


class ScheduleFragment : Fragment() {

    private lateinit var dbref: DatabaseReference
    private lateinit var lessonRecyclerview: RecyclerView
    private lateinit var lessonArrayList: ArrayList<Lesson>
    private lateinit var binding: FragmentScheduleBinding

    private val viewModel: ScheduleViewModel by viewModels()

    companion object {
        lateinit var dayOfTheWeek: String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(layoutInflater)
        val view = binding.root

        lessonRecyclerview = binding.ScheduleRecyclerView
        lessonRecyclerview.layoutManager = LinearLayoutManager(this.context)

        binding.imageVectorBack.setOnClickListener { onLeftClicked() }
        binding.imageVectorForward.setOnClickListener { onRightClicked() }
        binding.scheduleAddButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_scheduleFragment_to_fragmentAddToSchedule)
        }
        viewModel.currentWeekDay.observe(viewLifecycleOwner) { newWord ->
            dayOfTheWeek = newWord
            binding.nameOfDay.text = newWord
            getLessonData()
        }

        getLessonData()

        return view
    }

    private fun onLeftClicked() = viewModel.setPreviousWeekDay()

    private fun onRightClicked() = viewModel.setNextWeekDay()

    private fun getLessonData() {

        dbref =
            FirebaseDatabase.getInstance("https://sdu-mobile-cd4a4-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("Lessons")
        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                lessonArrayList = arrayListOf<Lesson>()

                if (snapshot.exists()) {

                    for (id in snapshot.children) {
                        if (LoginFragment.getSduId() == id.key) {
                            for (weekDay in id.children) {
                                if (dayOfTheWeek == weekDay.key) {
                                    for (item in weekDay.children) {
                                        val lesson = item.getValue(Lesson::class.java)
                                        lessonArrayList.add(lesson!!)
                                    }
                                }
                            }
                        }

                    }

                    lessonRecyclerview.adapter = ListAdapter(lessonArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                val toast = Toast.makeText(
                    context,
                    "Some error happened",
                    Toast.LENGTH_SHORT
                )
            }

        })

    }

}