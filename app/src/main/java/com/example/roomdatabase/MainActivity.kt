package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.data.CompaniesDatabase
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Owner
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = CompaniesDatabase.getDatabase(this).companyDao()

        val owners = listOf(Owner(1, "Mike Smith", 1), Owner(2, "David White", 2))
        val companies = listOf(Company(1, "E-speed",1), Company(2, "SAT Services", 2))
        val employees =
            listOf(Employee(1, "Adam", 1), Employee(2, "Matthew", 1), Employee(3, "Sonya", 1))

        lifecycleScope.launch {
            owners.forEach {
                dao.addOwner(it)
            }
            companies.forEach {
                dao.addCompany(it)
            }
            employees.forEach {
                dao.addEmployee(it)
            }

            val companyWithOwner = dao.getCompanyAndOwnerWithCompanyId(1)
            Log.d("main", "onCreate: ${companyWithOwner.first().owner?.ownerName}")

            val companyWithEmployees = dao.getCompanyWithEmployees(1)
            Log.d("main", "onCreate: ${companyWithEmployees.employees.size}")
        }
    }
}