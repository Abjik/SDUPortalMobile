package com.example.sdu_portal_mobile.rvmvvm.RVAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.ListItemBinding
import com.example.sdu_portal_mobile.rvmvvm.Task

class RecycleViewAdapter(private val clickListener: (Task) -> Unit) :
    ListAdapter<Task, MyViewHolder>(TaskDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

}

object TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task, clickListener: (Task) -> Unit) {
        binding.todoTitle.text = task.title
        binding.todoSubtitle.text = task.subTitle
        binding.listItemLayout.setOnClickListener(){
            clickListener(task)
        }
    }
}