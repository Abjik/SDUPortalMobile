package com.example.sdu_portal_mobile.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.sdu_portal_mobile.DB.AccDao

class UserRepository(private val accDao: AccDao){
//    val allUsers: LiveData<Int> = accDao.loadAllUsers()
//    val size = accDao.loadAllUsersSize()
    fun getUse(): List<Int> {
        return accDao.loadAllUsers()
    }

}