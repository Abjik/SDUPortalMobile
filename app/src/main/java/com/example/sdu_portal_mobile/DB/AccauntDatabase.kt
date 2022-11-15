package com.example.sdu_portal_mobile.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        StudentsTable::class
    ]
)
abstract class AccauntDatabase: RoomDatabase() {
    abstract fun getAccDao(): AccDao
}