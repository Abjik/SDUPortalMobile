package com.example.sdu_portal_mobile.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.DB.AccDao
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.LoginViewModel
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment(private val loginViewModel: LoginViewModel) : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
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
                    val idnam = loginViewModel.getUseres()
                    val size = idnam.size
                    for (i in IntRange(0, size - 1)) {
                        if (logi == idnam[i].toString() && pass == idnam[i].toString()) {
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