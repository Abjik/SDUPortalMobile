package com.example.sdu_portal_mobile.rvmvvm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_data_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="task_id")
    var id : Int,

    @ColumnInfo(name="task_title")
    var title : String,

    @ColumnInfo(name="task_subTitle")
    var subTitle : String
)
