package com.example.sdu_portal_mobile.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room

object DataBaseModule{
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        dataTest::class.java,
        "test_database"
    ).createFromAsset("database/stud.db").build()

    fun provideDao(database: dataTest) = database.UserDao
}