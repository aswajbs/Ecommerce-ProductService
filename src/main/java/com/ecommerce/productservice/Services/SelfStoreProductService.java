package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Repositories.Productrepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfStoreProductService implements ProductService{
    private Productrepo productrepo;
    public SelfStoreProductService(Productrepo productrepo) {
        this.productrepo = productrepo;
    }
    @Override
    public Product getProduct(Long id) throws ProductNotFoundException, IdOutOfBoundException {
        Optional<Product> product = productrepo.findById(id);
        if(product.isEmpty())
            throw new ProductNotFoundException("Product not found");

        return product.get();
    }
    @Override
    public List<Product> getAllProducts() {
        return productrepo.findAll();
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
