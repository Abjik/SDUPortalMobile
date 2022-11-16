package com.example.sdu_portal_mobile.DB

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AccDao {

    @Query("select ID from students")
    fun loadAllUsers(): Int

}