package com.example.roomdatabase.data.dao

import androidx.room.*
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Owner
import com.example.roomdatabase.data.entities.relations.CompanyAndOwner
import com.example.roomdatabase.data.entities.relations.CompanyWithEmployees

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCompany(company: Company)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOwner(owner: Owner)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEmployee(employee: Employee)

    @Transaction
    @Query("SELECT * FROM companies WHERE company_id = :companyId")
    suspend fun getCompanyAndOwnerWithCompanyId(companyId: Int): List<CompanyAndOwner>

    @Transaction
    @Query("SELECT * FROM companies WHERE company_id = :companyId")
    suspend fun getCompanyWithEmployees(companyId: Int): CompanyWithEmployees
}