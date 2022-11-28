package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentTodosBinding
import com.example.sdu_portal_mobile.model.RVAdapter
import com.example.sdu_portal_mobile.model.TodoModel

class TodosFragment : Fragment() {
    private lateinit var rvAdapter: RVAdapter
    private lateinit var taskList : List<TodoModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTodosBinding.inflate(inflater)

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_todosFragment_to_addTodoFragment)
        }

        binding.buttonDONE.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_todosFragment_to_donesFragment2)
        }



        loadTodos()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.rvList.setLayoutManager(layoutManager)
        rvAdapter = RVAdapter(taskList)
        binding.rvList.adapter = rvAdapter

        return binding.root
    }

    private fun loadTodos() {
        taskList = listOf(
            TodoModel("Java quiz" , "until Monday"),
            TodoModel("Kotlin project" , "until Monday"),
            TodoModel("Python pandas" , "until Monday"),
            TodoModel("JavaScript web" , "until Monday"),
            TodoModel("FPGA thing" , "until Monday")
        )
    }
}