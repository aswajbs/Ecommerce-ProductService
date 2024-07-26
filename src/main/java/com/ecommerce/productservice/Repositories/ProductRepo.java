package com.ecommerce.productservice.Repositories;

import com.ecommerce.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo  extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(Long aLong);

}