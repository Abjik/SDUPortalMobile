package com.example.sdu_portal_mobile.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.ListItemBinding

class RVAdapter(private val dataset: List<TodoModel>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dataset[position]){
                binding.todoTitle.text = this.todo_Title
                binding.todoSubtitle.text = this.todo_Subtitle
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}