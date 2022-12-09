package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
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


class ScheduleFragment : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var lessonRecyclerview : RecyclerView
    private lateinit var lessonArrayList : ArrayList<Lesson>
    private lateinit var binding: FragmentScheduleBinding

    private val viewModel: ScheduleViewModel by viewModels()


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
        binding.scheduleAddButton.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_scheduleFragment_to_fragmentAddToSchedule)
        }

        viewModel.currentWeekDay.observe(viewLifecycleOwner) { newWord ->
            binding.nameOfDay.text = newWord
        }

        lessonArrayList = arrayListOf<Lesson>()
        getLessonData()

        return view
    }

    private fun onLeftClicked()=viewModel.setPreviousWeekDay()

    private fun onRightClicked()=viewModel.setNextWeekDay()

    private fun getLessonData() {

        dbref = FirebaseDatabase.getInstance("https://sdu-mobile-cd4a4-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("Lessons")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (lessonSnapshot in snapshot.children){

                        val lesson = lessonSnapshot.getValue(Lesson::class.java)
                        lessonArrayList.add(lesson!!)

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