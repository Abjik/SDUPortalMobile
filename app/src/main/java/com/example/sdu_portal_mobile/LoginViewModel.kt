package com.example.sdu_portal_mobile

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdu_portal_mobile.DB.AccDao
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.DB.AccauntTuple
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.userAgent


class LoginViewModel: ViewModel() {
    private val _user = MutableLiveData("TEST")
    val user = _user
    fun onLoginClicked() {
        viewModelScope.launch {

//                val size = AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers().size
//                val idname = AccauntDatabase.getInstance(requireContext()).getAccDao().loadAllUsers().toString()
        }
    }
}