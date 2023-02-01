package com.example.roomdatabase.data.repository

import com.example.roomdatabase.data.dao.CompanyDao
import javax.inject.Inject

class CompanyRepository @Inject constructor(
    val companyDao:CompanyDao
) {
}