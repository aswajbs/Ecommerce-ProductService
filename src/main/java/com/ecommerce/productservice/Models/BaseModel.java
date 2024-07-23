package com.ecommerce.productservice.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}