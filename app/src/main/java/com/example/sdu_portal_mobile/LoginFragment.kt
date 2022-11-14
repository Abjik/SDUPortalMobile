package com.example.sdu_portal_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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