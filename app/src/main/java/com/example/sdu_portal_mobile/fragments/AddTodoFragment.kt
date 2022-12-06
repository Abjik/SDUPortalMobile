package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentAddTodoBinding

class AddTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddTodoBinding.inflate(inflater)

        binding.addTodo.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_addTodoFragment_to_todosFragment)
        }
        binding.addTodoBackButton.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_addTodoFragment_to_todosFragment)}
        return binding.root
    }
}