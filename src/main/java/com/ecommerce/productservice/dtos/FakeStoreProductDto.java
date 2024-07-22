package com.ecommerce.productservice.dtos;

import com.ecommerce.productservice.Models.Category;
import com.ecommerce.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;


}
