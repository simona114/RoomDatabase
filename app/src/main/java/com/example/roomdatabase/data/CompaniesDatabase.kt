package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.dao.EmployeeDao
import com.example.roomdatabase.data.entities.Employee
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class CompaniesDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile()
        private var INSTANCE: CompaniesDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): CompaniesDatabase {
            val tempInstance = INSTANCE

            /* Returns the instance if it already exists */
            if (tempInstance != null) {
                return tempInstance
            }

            /* Create a new instance */
            synchronized(this){
                var instance = Room.databaseBuilder(context.applicationContext, CompaniesDatabase::class.java, "users_database").build()
                instance = INSTANCE!!
                return instance
            }
        }
    }
}