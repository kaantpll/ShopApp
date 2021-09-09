package com.example.northwind.ShopApp.dto.convert;

import com.example.northwind.ShopApp.dto.ProductDto;
import com.example.northwind.ShopApp.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    private final CategoryDtoConverter categoryDtoConverter;

    public ProductDtoConverter(CategoryDtoConverter categoryDtoConverter) {
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public ProductDto convert(Product from){
        return new ProductDto(
                from.getId(),
                from.getProductName(),
                from.getQuantityPerUnit(),
                from.getUnitPrice(),
                from.getUnitsInStock(),
                categoryDtoConverter.convert(from.getCategory()).copy(
                     from.getCategory().getCategoryId(),from.getCategory().getCategoryName()
                )
                );
    }
}
