package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.convert.CategoryDtoConverter;
import com.example.northwind.ShopApp.exception.CategoryNotFoundException;
import com.example.northwind.ShopApp.model.Category;
import com.example.northwind.ShopApp.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class CategoryServiceTest {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private CategoryDtoConverter categoryDtoConverter;

    @BeforeEach
    public void setup()
    {
        categoryRepository = mock(CategoryRepository.class);
        categoryDtoConverter = mock(CategoryDtoConverter.class);
        categoryService = new CategoryService(categoryDtoConverter,categoryRepository);
    }

    @Test
    public void testFindByCategoryId_whenCategoryIdExists_shouldReturnCategory(){
        Category category = new Category(1,"kaan", List.of());
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

        Category result = categoryService.findCategoryById(1);
        Assert.assertEquals(result,category);
    }

    @Test
    public void testFindByCategoryId_whenCategoryIdDoesNotExist_shouldThrowCategoryNotFoundException(){

        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class,() ->categoryService.getCategoryById(1));

    }

}