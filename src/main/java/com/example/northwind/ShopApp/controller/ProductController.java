package com.example.northwind.ShopApp.controller;


import com.example.northwind.ShopApp.dto.ProductDto;
import com.example.northwind.ShopApp.dto.request.CreateProductRequest;
import com.example.northwind.ShopApp.model.Product;
import com.example.northwind.ShopApp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDto>> getById(@PathVariable int id){
        return  ResponseEntity.ok(productService.findCategoryId(id));
    }
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody CreateProductRequest productRequest){
        return ResponseEntity.ok(productService.createAccount(productRequest));
    }

    @GetMapping(value="/unitPrice={unitPrice}")
    public ResponseEntity<List<ProductDto>> getProductLessThanUnitPrice(@RequestParam int unitPrice){
        return ResponseEntity.ok(productService.getProductLessThanUnitPrice(unitPrice));
    }
/*
    @DeleteMapping("/delete={id}")
    public ResponseEntity deleteProductById(@PathVariable int id){

        return ResponseEntity.ok(productService.deleteProductById(id));
    }*/

}
