package com.example.roomdatabase.data.entities.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

/* Demonstrate N:M relationship */
@Entity(primaryKeys = ["employee_id", "project_id"])
data class EmployeeProjectCrossRef(
    @ColumnInfo(name = "employee_id")
    val employeeId: Int,
    @ColumnInfo(name = "project_id")
    val projectId: Int,
)