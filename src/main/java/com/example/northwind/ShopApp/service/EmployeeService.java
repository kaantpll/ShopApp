package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.EmployeeDto;
import com.example.northwind.ShopApp.dto.convert.EmployeeDtoConverter;
import com.example.northwind.ShopApp.dto.request.CreateEmployeeRequest;
import com.example.northwind.ShopApp.model.Employee;
import com.example.northwind.ShopApp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoConverter employeeDtoConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoConverter employeeDtoConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoConverter = employeeDtoConverter;
    }

    public List<EmployeeDto> getAllEmployee(){
        return employeeRepository.findAll().stream().map(employeeDtoConverter::convert).collect(Collectors.toList());
    }

    @Transactional
    public EmployeeDto createEmployee(CreateEmployeeRequest request){
         Employee employee = new Employee(
                 10,
                 request.getFirstName(),
                 request.getLastName(),
                 request.getTitle(),
                 request.getAddress(),
                 request.getCity()
         );
        return employeeDtoConverter.convert(employeeRepository.save(employee));
    }
}
