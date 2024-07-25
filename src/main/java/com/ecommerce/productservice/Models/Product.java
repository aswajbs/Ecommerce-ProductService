package com.ecommerce.productservice.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="2")
public class Product extends BaseModel {
    private String title;
    private double price;
    @ManyToOne
    private Category category;
}
