package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("selfstoreps")
public class SelfStoreProductService implements ProductService {
    private ProductRepo productRepo;
    public SelfStoreProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public Product getProduct(Long id) throws ProductNotFoundException, IdOutOfBoundException {
        Optional<Product> product = productRepo.findById(id);
        if (product.isEmpty())
            throw new ProductNotFoundException("Product not found");

        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
                return productRepo.findAll();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
