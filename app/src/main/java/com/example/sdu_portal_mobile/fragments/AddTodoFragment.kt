package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentAddTodoBinding
import com.example.sdu_portal_mobile.rvmvvm.TaskDataBase
import com.example.sdu_portal_mobile.rvmvvm.TaskRepository
import com.example.sdu_portal_mobile.rvmvvm.TaskViewModel
import com.example.sdu_portal_mobile.rvmvvm.TaskViewModelFactory

class AddTodoFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddTodoBinding.inflate(inflater)

        val dao = TaskDataBase.getInstance(requireContext()).taskDAO
        val repository = TaskRepository(dao)
        val factory = TaskViewModelFactory(repository)
        taskViewModel = ViewModelProvider(this,factory).get(TaskViewModel::class.java)
        binding.myViewModel = taskViewModel
        binding.lifecycleOwner = this

        binding.addTodoButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_addTodoFragment_to_todosFragment)
        }
        return binding.root
    }
}