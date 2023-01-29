package com.example.roomdatabase.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Owner

/* Demonstrate 1:1 relationship */
class CompanyAndOwner (
    @Embedded  val company: Company,
    @Relation(
        parentColumn = "company_id",
        entityColumn = "company_id"
    )  val owner: Owner
)