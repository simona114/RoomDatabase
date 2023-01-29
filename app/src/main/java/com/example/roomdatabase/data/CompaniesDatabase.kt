package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.dao.CompanyDao
import com.example.roomdatabase.data.dao.EmployeeDao
import com.example.roomdatabase.data.entities.Company
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.entities.Owner
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [Company::class, Owner::class, Employee::class],
    version = 4
)
abstract class CompaniesDatabase : RoomDatabase() {

    abstract fun companyDao(): CompanyDao
    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: CompaniesDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): CompaniesDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CompaniesDatabase::class.java,
                    "companies_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}