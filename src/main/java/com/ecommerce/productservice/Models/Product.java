package com.ecommerce.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="User_id")
public class Product extends BaseModel {
    private String title;
    private double price;
    @ManyToOne
    private Category category;


}
