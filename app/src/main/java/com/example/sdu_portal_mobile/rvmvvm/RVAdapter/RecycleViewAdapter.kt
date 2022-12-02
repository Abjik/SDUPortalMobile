package com.example.sdu_portal_mobile.rvmvvm.RVAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.ListItemBinding
import com.example.sdu_portal_mobile.rvmvvm.Task

class RecycleViewAdapter(private val clickListener: (Task) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val taskList = ArrayList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(taskList[position], clickListener)
    }

    fun setList(tasks: List<Task>) {
        taskList.clear()
        taskList.addAll(tasks)

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