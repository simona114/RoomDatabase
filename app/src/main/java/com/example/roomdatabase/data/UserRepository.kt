package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.entities.User

class UserRepository(private val userDao: UserDao) {

    suspend fun readAllUsers(): LiveData<List<User>> = userDao.readAllUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}