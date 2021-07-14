package com.example.northwind.ShopApp.dto.convert;


import com.example.northwind.ShopApp.dto.CategoryDto;
import com.example.northwind.ShopApp.model.Category;
import com.example.northwind.ShopApp.model.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {

    private final ProductDtoConverter productDtoConverter;


    public CategoryDtoConverter(ProductDtoConverter productDtoConverter) {
        this.productDtoConverter = productDtoConverter;

    }

    public CategoryDto convert(Category from){
        return new CategoryDto(
                from.getCategoryId(),
                from.getCategoryName()

        );
    }
}
