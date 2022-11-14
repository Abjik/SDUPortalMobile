package com.example.sdu_portal_mobile.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [userTable::class], version = 1, exportSchema = false)
abstract class dataTest : RoomDatabase() {

    abstract val UserDao: userDao

    companion object {

        @Volatile
        private var INSTANCE: dataTest? = null

        fun getInstance(context: Context): dataTest {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        dataTest::class.java,
                        "test_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}