package com.example.northwind.ShopApp.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class CreateEmployeeRequest(

    @field:NotEmpty(message="This field is not empty !!!")
    val firstName : String,
    @field:NotEmpty(message="This field is not empty !!!")
    val lastName : String,
    @field:NotEmpty(message="This field is not empty !!!")
    val title : String,
    @field:NotEmpty(message="This field is not empty !!!")
    val address : String,
    @field:NotEmpty(message="This field is not empty !!!")
    val city : String
)