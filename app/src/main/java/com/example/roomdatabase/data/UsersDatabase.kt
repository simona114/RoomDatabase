package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.entities.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile()
        private var INSTANCE: UsersDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): UsersDatabase {
            val tempInstance = INSTANCE

            /* Returns the instance if it already exists */
            if (tempInstance != null) {
                return tempInstance
            }

            /* Create a new instance */
            synchronized(this){
                var instance = Room.databaseBuilder(context.applicationContext, UsersDatabase::class.java, "users_database").build()
                instance = INSTANCE!!
                return instance
            }
        }
    }
}