package com.example.sdu_portal_mobile.DB

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AccDao {

    @Query("SELECT * FROM students WHERE users = users")
    fun loadAllUsers(): Array<AccauntTuple>

}