package com.example.northwind.ShopApp.dto

import com.example.northwind.ShopApp.model.Category

data class ProductDto(
    val id : Int,
    val productName : String,
    val quantityPerUnit : String,
    val unitPrice :Short,
    val unitsInStock : Short,
    val category : Category
)