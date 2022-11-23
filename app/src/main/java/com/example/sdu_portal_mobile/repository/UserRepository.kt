package com.example.sdu_portal_mobile.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sdu_portal_mobile.DB.AccDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class UserRepository(private val accDao: AccDao){
//    val allUsers: LiveData<List<Int>> = accDao.loadAllUsers()
//    val sizes : Int = accDao.loadAllUsersSize()
}