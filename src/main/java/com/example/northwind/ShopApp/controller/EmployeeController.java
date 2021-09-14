package com.example.northwind.ShopApp.controller;

import com.example.northwind.ShopApp.dto.EmployeeDto;
import com.example.northwind.ShopApp.dto.request.CreateEmployeeRequest;
import com.example.northwind.ShopApp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/manager/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    private ResponseEntity<List<EmployeeDto>> getAllUser(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @PostMapping
    private ResponseEntity<EmployeeDto> addNewEmployee(@Valid @RequestBody CreateEmployeeRequest request){
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }
}
