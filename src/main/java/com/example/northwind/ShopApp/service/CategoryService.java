package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.CategoryDto;
import com.example.northwind.ShopApp.dto.convert.CategoryDtoConverter;
import com.example.northwind.ShopApp.exception.CategoryNotFoundException;
import com.example.northwind.ShopApp.model.Category;
import com.example.northwind.ShopApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryDtoConverter categoryDtoConverter;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryDtoConverter categoryDtoConverter, CategoryRepository categoryRepository) {
        this.categoryDtoConverter = categoryDtoConverter;
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategory(){
        return categoryRepository.findAll().stream().map(categoryDtoConverter::convert).collect(Collectors.toList());
    }

    protected Category findCategoryById(int id){
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new CategoryNotFoundException("Category id not found")
                );
    }

    public CategoryDto getCategoryById(int id){
        return categoryDtoConverter.convert(findCategoryById(id));
    }
}
