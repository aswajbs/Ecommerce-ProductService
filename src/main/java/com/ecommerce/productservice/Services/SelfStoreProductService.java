package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Category;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Repositories.CategoryRepo;
import com.ecommerce.productservice.Repositories.Productrepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfStoreProductService implements ProductService{
    private Productrepo productrepo;
    private CategoryRepo categoryrepo;
    public SelfStoreProductService(Productrepo productrepo, CategoryRepo categoryrepo) {
        this.productrepo = productrepo;
        this.categoryrepo = categoryrepo;
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
    public Product addProduct(Product product) {
        Category category ;
        if(product.getCategory() != null){
            category=categoryrepo.save(product.getCategory());
            product.setCategory(category);}

        return productrepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        if(productrepo.existsById(id))
            productrepo.deleteById(id);
        else
            throw new ProductNotFoundException("Product with id "+id);
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
        if(productrepo.existsById(id))
                    return productrepo.save(product);
        else
            throw new ProductNotFoundException("Product with id "+id );
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        if(productrepo.existsById(id))
            return productrepo.save(product);
        else
            throw new ProductNotFoundException("Product with id "+id);
    }
}
