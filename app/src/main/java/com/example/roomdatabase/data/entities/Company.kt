package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
class Company(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "company_name")
    val companyName: String?,
    @ColumnInfo(name = "owner_name")
    val ownerName: String?,
)