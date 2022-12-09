package com.example.sdu_portal_mobile.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AccDao {

    @Query("select ID from students")
    fun loadAllUsers(): LiveData<List<Int>>

    @Query("select COUNT(ID) from students")
    fun loadAllUsersSize(): Int
}