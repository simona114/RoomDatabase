package com.example.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    suspend fun readAllUsers(): LiveData<List<User>> = userDao.readAllUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}