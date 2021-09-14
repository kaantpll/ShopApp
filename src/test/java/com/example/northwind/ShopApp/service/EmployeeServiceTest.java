package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.convert.EmployeeDtoConverter;
import com.example.northwind.ShopApp.dto.request.CreateEmployeeRequest;
import com.example.northwind.ShopApp.model.Employee;
import com.example.northwind.ShopApp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    private EmployeeService employeeService;
    private EmployeeDtoConverter converter;
    private EmployeeRepository repository;

    @BeforeEach
    public void setup(){
        converter = mock(EmployeeDtoConverter.class);
        repository = mock(EmployeeRepository.class);

        employeeService = new EmployeeService(repository,converter);
    }

    @Test
    void testCreateEmployee() {

        Employee employee = new Employee(1,"Kardi","B","Aşçu","Akcaabat/Mersin","Sari");

        when(repository.save(employee)).thenReturn(employee);


    }
}