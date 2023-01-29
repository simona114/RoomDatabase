package com.example.roomdatabase.data.dao

import androidx.room.*
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Owner
import com.example.roomdatabase.data.entities.Project
import com.example.roomdatabase.data.entities.relations.*

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCompany(company: Company)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOwner(owner: Owner)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEmployee(employee: Employee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProject(project: Project)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployeeProjectCrossRef(crossRef: EmployeeProjectCrossRef)

    @Transaction
    @Query("SELECT * FROM companies WHERE company_id = :companyId")
    suspend fun getCompanyAndOwnerWithCompanyId(companyId: Int): List<CompanyAndOwner>

    @Transaction
    @Query("SELECT * FROM companies WHERE company_id = :companyId")
    suspend fun getCompanyWithEmployees(companyId: Int): CompanyWithEmployees

    //todo:fix
//    @Transaction
//    @Query("SELECT * FROM projects WHERE id = :projectId")
//    suspend fun getEmployeesOfProject(projectId: Int): List<ProjectWithEmployees>
//
//    @Transaction
//    @Query("SELECT * FROM employees WHERE id = :employeeId")
//    suspend fun getProjectsOfEmployee(employeeId: Int): List<EmployeeWithProjects>

}