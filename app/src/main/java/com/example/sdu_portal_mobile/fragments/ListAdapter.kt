package com.example.sdu_portal_mobile.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.DB.Lesson
import com.example.sdu_portal_mobile.R

class ListAdapter(private val lessons_list: ArrayList<Lesson>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_adapter,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentLesson = lessons_list[position]

        holder.interval.text = currentLesson.timeInterval
        holder.courseCode.text = currentLesson.courseCode
        holder.lessonName.text = currentLesson.courseName
        holder.cabinet.text = currentLesson.cabinet
    }

    override fun getItemCount(): Int {
        return lessons_list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val interval: TextView = itemView.findViewById(R.id.interval)
        val courseCode: TextView = itemView.findViewById(R.id.course_code)
        val lessonName: TextView = itemView.findViewById(R.id.name)
        val cabinet: TextView = itemView.findViewById(R.id.cabinet)
    }
}