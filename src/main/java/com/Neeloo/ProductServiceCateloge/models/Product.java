package com.Neeloo.ProductServiceCateloge.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product  extends  BaseModel{

    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
    private int numberOfSales;
}
