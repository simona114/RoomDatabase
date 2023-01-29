package com.example.roomdatabase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "owners")
class Owner(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "owner_name")
    val ownerName: String?,
    @ColumnInfo(name = "company_name")
    val companyName: String?,
)