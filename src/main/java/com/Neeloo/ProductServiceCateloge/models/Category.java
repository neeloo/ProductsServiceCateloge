package com.Neeloo.ProductServiceCateloge.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends  BaseModel{

    private List<Product> products;
    private String name;
    private String description;
    private String imageUrl;
}
