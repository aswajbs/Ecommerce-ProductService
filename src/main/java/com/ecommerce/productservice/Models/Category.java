package com.ecommerce.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel {
    private String Name;
    private String Description;
}
