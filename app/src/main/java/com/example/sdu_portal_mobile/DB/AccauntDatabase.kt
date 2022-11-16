package com.example.sdu_portal_mobile.DB

import android.content.Context
import android.graphics.Typeface.createFromAsset
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        StudentsTable::class
    ]
)
abstract class AccauntDatabase: RoomDatabase() {
    abstract fun getAccDao(): AccDao

    companion object {
        private var INSTANCE: AccauntDatabase? = null

        fun getInstance(context: Context): AccauntDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AccauntDatabase::class.java,
                        "test"
                    ).createFromAsset("stud.db")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}