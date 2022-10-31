package com.example.sdu_portal_mobile.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.databinding.ListItemBinding

class RVAdapter (val items : MutableList<TodoModel>)
    : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    private lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding=ListItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount() = items.size
    inner class ViewHolder(itemView : ListItemBinding) : RecyclerView.ViewHolder(itemView.root){
        fun bind(item : TodoModel){
            binding.apply {
                todoTitle.text=item.todo_Title
                todoSubtitle.text=item.todo_Subtitle
            }
        }
    }
}