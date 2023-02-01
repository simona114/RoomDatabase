package com.example.roomdatabase.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.data.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val employeeRepository: EmployeeRepository
) : ViewModel() {

    private val _employeesLiveData = MutableLiveData<List<Employee>?>()
    val employeesLiveData = _employeesLiveData

        fun getEmployees(){
           val result = employeeRepository.readAllEmployees()
            _employeesLiveData.postValue(result)
        }

    fun saveEmployee(employee: Employee) {
        viewModelScope.launch {
            employeeRepository.addEmployee(employee)
        }
    }

}