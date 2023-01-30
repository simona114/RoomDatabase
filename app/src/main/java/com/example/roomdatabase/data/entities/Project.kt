package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "projects")
data class Project(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "project_id")
    val id: Int,
    @ColumnInfo(name = "project_name")
    val name: String?,
)