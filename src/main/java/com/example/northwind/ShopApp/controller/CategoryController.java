package com.example.northwind.ShopApp.controller;

import com.example.northwind.ShopApp.dto.CategoryDto;
import com.example.northwind.ShopApp.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategory")
    private ResponseEntity<List<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CategoryDto> getCategoryWithById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


}
