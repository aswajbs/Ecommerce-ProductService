package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/Products")
public class Productcontroller {
    private ProductService productService;

    public Productcontroller(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productService.getProduct(id);
    }
    @GetMapping("")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("{id}") long id,@RequestBody Product product){

        return productService.updateProduct(id,product);
    }

}
