package com.example.northwind.ShopApp.dto.convert;

import com.example.northwind.ShopApp.dto.EmployeeDto;
import com.example.northwind.ShopApp.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoConverter {

    public EmployeeDto convert(Employee from ){
        return new EmployeeDto(
                from.getFirstName(),
                from.getLastName(),
                from.getTitle(),
                from.getAddress(),
                from.getCity()
        );
    }
}
