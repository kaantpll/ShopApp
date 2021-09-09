package com.example.northwind.ShopApp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.FORBIDDEN)
class ForbiddenUserException : RuntimeException{
    constructor(message: String?) : super(message)
}