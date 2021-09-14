package com.example.northwind.ShopApp.model

import javax.persistence.*

@Entity
@Table(name = "employees")
data class Employee (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    val id : Integer,

    @Column(name="first_name")
    val firstName:String,

    @Column(name = "last_name")
    val lastName:String,

    @Column(name="title")
    val title :String,

    @Column(name="address")
    val address : String,

    @Column(name="city")
    val city : String,
    )