package com.example.sdu_portal_mobile.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import com.example.sdu_portal_mobile.viewModels.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding:FragmentLoginBinding


    companion object {
        private var sduId: String = ""
         fun getSduId()
                : String {
            return sduId
        }
        fun setSduId(newId: String){
            sduId = newId
        }

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
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
                        if (logi == pass) {
                            sduId = logi
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

//        binding.button.setOnClickListener { view: View ->
//            viewModel.login(requireContext(), binding.login.text.toString(), binding.password.text.toString())
//            viewModel.test.observe(viewLifecycleOwner){
//                if(viewModel.test.value == true){
//                    view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
//                }
//                else{
//                    view.findNavController().navigate(R.id.loginFragment)
//                }
//            }
//        }

//        viewModel.test.observe(viewLifecycleOwner){
//            if(viewModel.test.value == true){
//                view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
//            }
//            else{
//                view.findNavController().navigate(R.id.loginFragment)
//            }
//        }

        return binding.root
    }


}