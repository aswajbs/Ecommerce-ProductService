package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        ResponseEntity<Product> response;
        try{

            response = new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
        } catch (RuntimeException e){
            response = new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }

       return response;

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
