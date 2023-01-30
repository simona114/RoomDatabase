package com.example.roomdatabase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.data.CompaniesDatabase
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Owner
import com.example.roomdatabase.data.entities.Project
import com.example.roomdatabase.data.entities.relations.EmployeeProjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = CompaniesDatabase.getDatabase(this).companyDao()

        val owners = listOf(Owner(1, "Mike Smith", 1), Owner(2, "David White", 2))
        val companies = listOf(Company(1, "E-speed", 1), Company(2, "SAT Services", 2))
        val employees =
            listOf(Employee(1, "Adam", 1), Employee(2, "Matthew", 1), Employee(3, "Sonya", 1))
        val projects = listOf(
            Project(1, "Smart home Android application"),
            Project(2, "Smart home iOS application"),
            Project(3, "E-Commerce website")
        )
        val employeeProjectRelations = listOf(
            EmployeeProjectCrossRef(1, 1),
            EmployeeProjectCrossRef(1, 2),
            EmployeeProjectCrossRef(2, 3),
            EmployeeProjectCrossRef(3, 3),
        )

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
            projects.forEach {
                dao.addProject(it)
            }

            employeeProjectRelations.forEach {
                dao.insertEmployeeProjectCrossRef(it)
            }

            val companyWithOwner = dao.getCompanyAndOwnerWithCompanyId(1)
            Log.d("main", "onCreate: ${companyWithOwner.first().owner?.ownerName}")

            val companyWithEmployees = dao.getCompanyWithEmployees(1)
            Log.d("main", "onCreate: ${companyWithEmployees.employees.size}")

            val projectsOfEmployee = dao.getProjectsOfEmployee(1)
            projectsOfEmployee.forEach { employeeWithProjects ->
                employeeWithProjects.project.forEach { project ->
                    Log.d("main", "onCreate: ${project.name}")
                }
            }
            val employeesOfProject = dao.getEmployeesOfProject(3)
            employeesOfProject.forEach { projectWithEmployees ->
                projectWithEmployees.employees.forEach { employee ->
                    Log.d("main", "onCreate: ${employee.name}")
                }
            }
        }
    }
}