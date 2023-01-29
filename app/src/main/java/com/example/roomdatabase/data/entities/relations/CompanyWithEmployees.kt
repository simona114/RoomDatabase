package com.example.roomdatabase.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee

/* Demonstrate 1:N relationship */
data class CompanyWithEmployees(
    @Embedded val company: Company,
    @Relation(
        parentColumn = "company_id",
        entityColumn = "company_id"
    )
    val employees: List<Employee>

)