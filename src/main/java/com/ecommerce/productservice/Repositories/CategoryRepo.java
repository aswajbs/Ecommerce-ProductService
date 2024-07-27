package com.ecommerce.productservice.Repositories;

import com.ecommerce.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Category save(Category category);

}
