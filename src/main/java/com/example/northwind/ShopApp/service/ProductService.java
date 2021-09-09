package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.ProductDto;
import com.example.northwind.ShopApp.dto.convert.ProductDtoConverter;
import com.example.northwind.ShopApp.dto.request.CreateProductRequest;
import com.example.northwind.ShopApp.model.Category;
import com.example.northwind.ShopApp.model.Product;
import com.example.northwind.ShopApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
        this.categoryService = categoryService;
    }

    public List<ProductDto> findCategoryId(int id){
        return productRepository.findById(id).stream().map(productDtoConverter::convert).collect(Collectors.toList());

    }
    public ProductDto createAccount(CreateProductRequest createProductRequest){

       Category category = categoryService.findCategoryById(createProductRequest.getCategoryDto().getCategoryId());

        Product product = new Product(
                createProductRequest.getProductName(),
                createProductRequest.getQuantityPerUnit(),
                createProductRequest.getUnitPrice(),
                createProductRequest.getUnitsInStock(),
                category
        );

        return productDtoConverter.convert(productRepository.save(product));
    }

    public List<ProductDto> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(productDtoConverter::convert).collect(Collectors.toList());
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

}
