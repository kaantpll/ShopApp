package com.example.northwind.ShopApp.repository

import ProductCategoryDto
import com.example.northwind.ShopApp.dto.ProductDto
import com.example.northwind.ShopApp.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product,Int> {
/*
    @Query("select * from products where product_name LIKE :'½productName½'")
    fun getByProductName(productName : String) : Product

    @Query("select * from products where product_name LIKE: '%productName%'")
    fun getByProductNameStartsWith(productName : String) : List<Product>
*/
//
//    fun unitPriceLessThan(price : Int) : List<Product>
//
//    fun unitPriceManyThan(price  :Int) : List<Product>
//
//    fun unitsInStockLessThan(price : Int): List<Product>
//
//    fun unitsInStockManyThan(price : Int): List<Product>
//
//    fun getByProductNameWithCategoryName() : List<ProductCategoryDto>

}