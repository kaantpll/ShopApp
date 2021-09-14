package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.CategoryDto;
import com.example.northwind.ShopApp.dto.ProductDto;
import com.example.northwind.ShopApp.dto.convert.CategoryDtoConverter;
import com.example.northwind.ShopApp.dto.convert.ProductDtoConverter;
import com.example.northwind.ShopApp.dto.request.CreateProductRequest;
import com.example.northwind.ShopApp.model.Category;
import com.example.northwind.ShopApp.model.Product;
import com.example.northwind.ShopApp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductService productService;
    private ProductDtoConverter productDtoConverter;
    private CategoryService categoryService;
    private ProductRepository productRepository;
    private CategoryDtoConverter categoryDtoConverter;

    @BeforeEach
    void setUp() {
        productDtoConverter = mock(ProductDtoConverter.class);
        productRepository = mock(ProductRepository.class);
        categoryService = mock(CategoryService.class);
        categoryDtoConverter = mock(CategoryDtoConverter.class);
        productService = new ProductService(productRepository,productDtoConverter,categoryService);
    }

    @Test
    void testCreateProduct_whenProductIdExistsAndProductNameNotEmpty() {
        CategoryDto categoryDto = new CategoryDto(1,"abc");
        CreateProductRequest createProductRequest
                = new CreateProductRequest("product1",
                "100",
                20,
                20,
                categoryDto);
        Category category = new Category(1,"kaan", List.of());
        Product product = new Product(1,"sfd","sdf",11,25,category);

        ProductDto productDto = new ProductDto(1,"sfd","sdf",11,25,categoryDto);

        when(categoryService.findCategoryById(1)).thenReturn(category);
        when(productRepository.save(product)).thenReturn(product);

        when(productDtoConverter.convert(product)).thenReturn(productDto);
        when(categoryDtoConverter.convert(category)).thenReturn(categoryDto);

       // assertEquals(category,categoryDto);
        assertEquals(product,productDto);

    }
}