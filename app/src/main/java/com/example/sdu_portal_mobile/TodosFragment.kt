package com.example.sdu_portal_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.databinding.FragmentTodosBinding

class TodosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTodosBinding.inflate(inflater)

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_todosFragment_to_addTodoFragment)
        }
        return binding.root
    }
}