package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "first_name")
    val firstName: String?,
    @ColumnInfo(name = "last_name")
    val lastName: String?,
    val age: Int?
)