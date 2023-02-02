package com.example.roomdatabase.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.roomdatabase.R
import com.example.roomdatabase.data.entities.Employee
import com.example.roomdatabase.databinding.FragmentBaseBinding
import com.example.roomdatabase.ui.viewmodels.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseFragment : Fragment() {

    private lateinit var binding: FragmentBaseBinding
    private val employeesViewModel: EmployeeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("base", "onViewCreated: here0")
        val employees =
            listOf(Employee(1, "Adam", 1), Employee(2, "Matthew", 1), Employee(3, "Sonya", 1))

        employees.forEach { employee ->
            employeesViewModel.saveEmployee(employee)
        }

        employeesViewModel.getEmployees()

        employeesViewModel.employeesLiveData.observe(viewLifecycleOwner) { savedEmployees ->
            Log.d("base", "onViewCreated: savedEmployeeesSize: ${savedEmployees.size}")

            savedEmployees.forEach {
                Log.d("base", "onViewCreated: ${it.name}")
            }
        }
    }


}

