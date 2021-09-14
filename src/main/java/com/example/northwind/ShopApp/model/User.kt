package com.example.northwind.ShopApp.model

import org.hibernate.annotations.Columns
import javax.persistence.*

@Entity
@Table(name="usersbn")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    val id : Int,

    @Column(name="email")
    val email:String,

    @Column(name="password")
    val password:String
){

    constructor(email: String,password: String):this(
        id=1,
        email = email,
        password = password
    )

}

