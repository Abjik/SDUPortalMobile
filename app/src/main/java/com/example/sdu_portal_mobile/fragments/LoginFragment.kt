package com.example.sdu_portal_mobile.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.room.Room
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentLoginBinding.inflate(inflater)
        binding.button.setOnClickListener { view: View ->

            lifecycleScope.launch {
                var test: Boolean = false
                withContext(Dispatchers.IO) {
                    val logi = binding.login.text.toString()
                    val pass = binding.password.text.toString()
                    val idname =
                        AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers()
                    val size = AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsersSize()
                    for (i in IntRange(0, size - 1)) {
                        if (logi == "" && pass == "") {
                            test = true
                            break
                        }
                    }
                }

                if (test) {
                    view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
                } else {
                    view.findNavController().navigate(R.id.loginFragment)
                }
            }


        }
        return binding.root
    }
}