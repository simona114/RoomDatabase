package com.example.roomdatabase.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Project

/*
Helper class that helps us query single employee and get all the projects that the employee works on
 */
data class EmployeeWithProjects(
    @Embedded val employee: Employee,
    @Relation(
        parentColumn = "employee_id",
        entityColumn = "project_id",
        associateBy = Junction(EmployeeProjectCrossRef::class)
    )
    val project: List<Project>

)