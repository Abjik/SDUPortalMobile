package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudInf")
data class userTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)