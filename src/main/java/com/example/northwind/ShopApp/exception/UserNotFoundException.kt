package com.example.northwind.ShopApp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException : RuntimeException {
    constructor(message: String?) : super(message)
}