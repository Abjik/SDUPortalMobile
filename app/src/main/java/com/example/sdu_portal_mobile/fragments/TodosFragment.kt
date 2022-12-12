package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentTodosBinding
import com.example.sdu_portal_mobile.model.RVAdapter
import com.example.sdu_portal_mobile.model.TodoModel
import com.example.sdu_portal_mobile.rvmvvm.*
import com.example.sdu_portal_mobile.rvmvvm.RVAdapter.RecycleViewAdapter
import java.util.concurrent.Flow

class TodosFragment : Fragment() {
//    private lateinit var rvAdapter: RVAdapter
//    private lateinit var taskList : List<TodoModel>

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var adapter: RecycleViewAdapter

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

        val dao = TaskDataBase.getInstance(requireContext()).taskDAO
        val repository = TaskRepository(dao)
        val factory = TaskViewModelFactory(repository)
        taskViewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)
        binding.todosViewModel = taskViewModel
        binding.lifecycleOwner = this



        binding.taskRecycleView.layoutManager = LinearLayoutManager(context)
        adapter = RecycleViewAdapter { selectedItem: Task -> listItemClicked(selectedItem) }
        binding.taskRecycleView.adapter = adapter
        initRecyclerView()

        taskViewModel.currentWeekDay.observe(viewLifecycleOwner) { newWord ->
            binding.nameOfDay.text = newWord
        }
        binding.imageVectorBack.setOnClickListener { onLeftClicked() }
        binding.imageVectorForward.setOnClickListener { onRightClicked() }

        return binding.root
    }

    private fun onLeftClicked() = taskViewModel.setPreviousWeekDay()

    private fun onRightClicked() = taskViewModel.setNextWeekDay()

    private fun initRecyclerView(){
        displaySubscribersList()
    }

    private fun displaySubscribersList(){
        taskViewModel.getAllTask().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun listItemClicked(task: Task){
        Toast.makeText(context,"selected name is ${task.title}",Toast.LENGTH_LONG).show()
    }

//    private fun loadTodos() {
//        taskList = listOf(
//            TodoModel("Java quiz" , "until Monday"),
//            TodoModel("Kotlin project" , "until Monday"),
//            TodoModel("Python pandas" , "until Monday"),
//            TodoModel("JavaScript web" , "until Monday"),
//            TodoModel("FPGA thing" , "until Monday")
//        )
//    }
}