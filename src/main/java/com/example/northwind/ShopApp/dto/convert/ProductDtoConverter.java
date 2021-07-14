package com.example.northwind.ShopApp.dto.convert;

import com.example.northwind.ShopApp.dto.ProductDto;
import com.example.northwind.ShopApp.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    public ProductDto convert(Product from){
        return new ProductDto(
                from.getId(),
                from.getProductName(),
                from.getQuantityPerUnit(),
                from.getUnitPrice(),
                from.getUnitsInStock(),
                from.getCategory()
        );
    }
}
