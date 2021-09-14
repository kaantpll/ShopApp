package com.example.northwind.ShopApp.repository

import com.example.northwind.ShopApp.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee,Int> {
}