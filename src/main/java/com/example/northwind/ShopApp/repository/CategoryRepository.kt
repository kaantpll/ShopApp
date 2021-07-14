package com.example.northwind.ShopApp.repository

import com.example.northwind.ShopApp.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int> {
}