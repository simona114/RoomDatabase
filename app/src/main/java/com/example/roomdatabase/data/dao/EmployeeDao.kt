package com.example.roomdatabase.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabase.data.entities.Employee

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEmployee(employee: Employee)

    @Query("SELECT * FROM employees ORDER BY id ASC")
    fun readAllEmployees(): LiveData<List<Employee>>
}