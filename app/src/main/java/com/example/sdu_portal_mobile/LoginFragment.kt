package com.example.sdu_portal_mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater)

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
        }
        return binding.root
    }
}