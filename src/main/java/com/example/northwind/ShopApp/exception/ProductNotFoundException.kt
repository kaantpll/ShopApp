package com.example.northwind.ShopApp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class ProductNotFoundException : RuntimeException {
    constructor(message: String?) : super(message)
}