package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String?,

)