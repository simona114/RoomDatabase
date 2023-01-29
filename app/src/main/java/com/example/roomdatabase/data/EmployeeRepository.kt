package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.dao.EmployeeDao
import com.example.roomdatabase.data.entities.Employee

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    suspend fun readAllEmployees(): LiveData<List<Employee>> = employeeDao.readAllEmployees()

    suspend fun addEmployee(employee: Employee) {
        employeeDao.addEmployee(employee)
    }
}