package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_sleep_quality_table")
data class userTable(

    @PrimaryKey(autoGenerate = true)
    private val key: Long = 0L,

    @ColumnInfo(name = "ID")
    private val ID: Int = 0,

    @ColumnInfo(name = "password")
    private val password: String = ""
)