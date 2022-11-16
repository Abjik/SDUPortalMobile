package com.example.sdu_portal_mobile.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.room.Room
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            launch(Dispatchers.IO) {
                println(AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers())
            }
        }
        val binding = FragmentLoginBinding.inflate(inflater)
            binding.button.setOnClickListener { view: View ->

                if(binding.login.text.toString().isNullOrBlank() && binding.password.text.toString().isNullOrBlank()){
                    view.findNavController().navigate(R.id.loginFragment)
                }else{
                    view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
                }

            }
        return binding.root
    }
}