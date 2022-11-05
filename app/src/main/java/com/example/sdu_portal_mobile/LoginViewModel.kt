package com.example.sdu_portal_mobile

import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding


class LoginViewModel: ViewModel() {
    private var _user = MutableLiveData("test")
    var user: LiveData<String> = _user
}