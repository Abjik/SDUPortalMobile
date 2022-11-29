package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R

class ScheduleFragment : Fragment() {
    var names =
        arrayOf("9:00 10:00", "10:00 11:00", "11:00 12:00", "12:00 13:00", "13:00 14:00", "14:00 15:00", "15:00 16:00", "16:00 17:00", "17:00 18:00")

    companion object {

        val weekdays =
            arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        var day: String = weekdays[0]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragment_schedule, container, false)

        val weekdayView = view.findViewById<TextView>(R.id.nameOfDay)
        weekdayView.text = day

        val recyclerView = view.findViewById<RecyclerView>(R.id.ScheduleRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = ListAdapter(names)

        val leftArrow = view.findViewById<ImageView>(R.id.imageVectorBack)
        val rightArrow = view.findViewById<ImageView>(R.id.imageVectorForward)

        leftArrow.setOnClickListener{

            if(weekdays.indexOf(day) != 0) {
                day = weekdays[weekdays.indexOf(day)-1]
            }
            else{
                day = weekdays[6]
            }

            val fragment = ScheduleFragment()


            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.activity_main_nav_host_fragment, fragment)?.commit()
        }
        rightArrow.setOnClickListener{

            if(weekdays.indexOf(day) != 6) {
                day = weekdays[weekdays.indexOf(day)+1]
            }
            else{
                day = weekdays[0]
            }

            val fragment = ScheduleFragment()


            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.activity_main_nav_host_fragment, fragment)?.commit()
        }
        return view
    }
}