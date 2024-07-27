package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/Products")
public class Productcontroller  {
    private ProductService productService;

    public Productcontroller(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException, IdOutOfBoundException {
       /*Handling Exception @ controller
       ResponseEntity<Product> response;
        try{

            response = new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
        } catch (RuntimeException e){
            response = new ResponseEntity<>(HttpStatus.FORBIDDEN);

        } */
        // Exception handling is carried out in the Service Class
      /* FakestoreProductservice call
      ResponseEntity<Product> response;
        response=new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);

       return response;*/
        //SelfStoreProductService
        ResponseEntity<Product> response;
        response = new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);
        return response;

    }
    @GetMapping("")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {

        return productService.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response;
        productService.deleteProduct(id);

    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) throws ProductNotFoundException {

        return productService.replaceProduct(id, product);   }

    @PostMapping
    public Product addProduct(@RequestBody Product product) throws ProductNotFoundException {
        return productService.addProduct(product);
    }


}
