package com.example.northwind.ShopApp.dto.request

import com.example.northwind.ShopApp.dto.CategoryDto
import com.example.northwind.ShopApp.model.Category
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateProductRequest (


        @field:NotBlank(message = "Product name is not empty !!")
        val productName : String,
        @field:NotNull(message = "Quantity of Product is not empty !!")
        val quantityPerUnit : String,
        @field:Min(0,message = "Unit Price is not less than 0")
        val unitPrice : Int,
        @field:Min(0,message = "Unit stock is not less than 0")
        val unitsInStock : Int,
        val categoryDto: CategoryDto
)