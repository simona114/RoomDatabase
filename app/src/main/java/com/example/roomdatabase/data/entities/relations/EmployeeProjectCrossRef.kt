package com.example.roomdatabase.data.entities.relations

import androidx.room.Entity

/* Demonstrate N:M relationship */
@Entity(primaryKeys = ["employeeId", "projectId"])
data class EmployeeProjectCrossRef(
    val employeeId: Int,
    val projectId: Int,
)