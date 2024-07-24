package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;

import java.util.List;

public interface ProductService {
     Product getProduct(Long id) throws ProductNotFoundException, IdOutOfBoundException;
     List<Product> getAllProducts();
     Product updateProduct(long id, Product product);

    Product replaceProduct(Long id, Product product);
    }