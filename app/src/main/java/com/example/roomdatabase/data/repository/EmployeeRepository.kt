package com.example.roomdatabase.data.repository

import com.example.roomdatabase.data.entities.Employee
import javax.inject.Inject

class EmployeeRepository @Inject constructor (private val localDataSource: EmployeesLocalDataSource) {

     fun readAllEmployees() = localDataSource.getEmployees()

    suspend fun addEmployee(employee: Employee) {
        localDataSource.saveEmployee(employee)
    }
}