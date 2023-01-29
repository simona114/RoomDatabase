package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.data.CompaniesDatabase
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Owner
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = CompaniesDatabase.getDatabase(this).companyDao()

        val owners = listOf(Owner(1, "Mike Smith", 1), Owner(2,"David White", 2))
        val companies = listOf(Company(1, "E-speed"), Company(2, "SAT Services"))

        lifecycleScope.launch {
            owners.forEach {
                dao.addOwner(it)
            }
            companies.forEach {
                dao.addCompany(it)
            }

            val companyWithOwner  = dao.getCompanyAndOwnerWithCompanyId(1)
            Log.d("main", "onCreate: ${companyWithOwner.first().owner.ownerName}")
        }
    }
}