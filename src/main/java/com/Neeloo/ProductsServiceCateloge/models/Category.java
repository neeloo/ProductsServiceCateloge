package com.Neeloo.ProductsServiceCateloge.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends  BaseModel{

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    private String name;
    private String description;
    private String imageUrl;
}
