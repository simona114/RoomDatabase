package com.example.roomdatabase.data.repository

import com.example.roomdatabase.data.dao.EmployeeDao
import com.example.roomdatabase.data.entities.Employee
import javax.inject.Inject

class EmployeesLocalDataSource @Inject constructor(val dao: EmployeeDao){
    fun getEmployees() = dao.readAllEmployees().value

    suspend fun saveEmployee(employee: Employee){
        dao.addEmployee(employee)
    }
}