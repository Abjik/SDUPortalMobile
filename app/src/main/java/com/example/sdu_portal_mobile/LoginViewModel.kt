package com.example.sdu_portal_mobile

import android.text.Editable
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding


class LoginViewModel: ViewModel() {
    private val _user = MutableLiveData("test")
    val user = _user
}