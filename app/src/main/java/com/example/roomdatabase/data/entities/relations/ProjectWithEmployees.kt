package com.example.roomdatabase.data.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Project

/*
Helper class that helps us query single project and get all the employees that work on this project
 */
data class ProjectWithEmployees(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(EmployeeProjectCrossRef::class)
    )
    val employees: List<Employee>

)