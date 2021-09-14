package com.example.northwind.ShopApp.dto


data class ProductDto(
    val id : Int,
    val productName : String,
    val quantityPerUnit : String,
    val unitPrice :Int,
    val unitsInStock : Int,
    val categoryDto : CategoryDto
)