package com.example.sdu_portal_mobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.fragment.app.viewModels
import com.example.sdu_portal_mobile.databinding.FragmentSettingsBinding
import com.example.sdu_portal_mobile.viewModels.LoginViewModel

class SettingsFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.u.observe(viewLifecycleOwner) {
//            binding.username.text = viewModel.u.value.toString()
//        }
//    }
}