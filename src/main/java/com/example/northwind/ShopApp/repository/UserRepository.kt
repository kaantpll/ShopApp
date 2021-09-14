package com.example.northwind.ShopApp.repository

import com.example.northwind.ShopApp.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface UserRepository : JpaRepository<User,Int>