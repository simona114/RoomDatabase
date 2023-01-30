package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    val employeeId: Int,
    @ColumnInfo(name = "employee_name")
    val name: String?,
    @ColumnInfo(name = "company_id")
    val companyId: Int?,

)