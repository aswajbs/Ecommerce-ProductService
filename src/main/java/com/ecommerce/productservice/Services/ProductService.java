package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;

import java.util.List;

public interface ProductService {
     Product getProduct(Long id) throws ProductNotFoundException, IdOutOfBoundException;
     List<Product> getAllProducts();
     Product addProduct(Product product);
     void deleteProduct(Long id) throws ProductNotFoundException;
     Product updateProduct(long id, Product product) throws ProductNotFoundException;
     Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
    }