package com.ecommerce.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="User_id")
public class Category extends BaseModel {
    private String Name;
    private String Description;
}
