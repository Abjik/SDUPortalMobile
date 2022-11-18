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

class LoginFragment : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentLoginBinding.inflate(inflater)
            binding.button.setOnClickListener { view: View ->
//                if(binding.login.text.toString().isNullOrBlank() && binding.password.text.toString().isNullOrBlank()){
//                    view.findNavController().navigate(R.id.loginFragment)
//                }else{
//                    view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
//                }
                lifecycleScope.launch {
                    launch(Dispatchers.IO) {
                        val logi = binding.login.text.toString()
                        val size = AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers().size
                        val idname = AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers().toString()
                        for (i in IntRange(0, size + 1)){
                            if (logi.equals(idname[i])){
                                view.findNavController().navigate(R.id.action_loginFragment_to_scheduleFragment)
                            }
                            else{
//                                view.findNavController().navigate(R.id.loginFragment)
//                                val toast = Toast.makeText(context, "text", Toast.LENGTH_SHORT)
//                                toast.show()
                            }
                        }
                    }
                }

            }
        return binding.root
    }
}