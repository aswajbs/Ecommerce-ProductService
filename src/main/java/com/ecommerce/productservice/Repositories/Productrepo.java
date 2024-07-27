package com.ecommerce.productservice.Repositories;

import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.Projections.ProductsbyIdName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Productrepo extends JpaRepository<Product,Long> {


    //Declared Query
    @Override
    Optional<Product> findById(Long aLong);
    //Hql Query
    @Query(value="select p.id as id,p.title as title from Product p where p.id=:x")
    ProductsbyIdName findProductsbyIdName(@Param("x") Long x);


    @Override
    void deleteById(Long aLong);

    @Override
    Product save(Product product);

    //Declared Queries
    @Override
    List<Product> findAll();

    //Native Queries-SQL
    @Query(nativeQuery = true,value="select * from product")
    List<Product> findallbySqlquery();

    //Hibernate Query Language(HQL)
    @Query(value="select p from Product p")
    List<Product> findallbyHql();
}
