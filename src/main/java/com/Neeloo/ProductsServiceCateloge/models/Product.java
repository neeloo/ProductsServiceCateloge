package com.Neeloo.ProductsServiceCateloge.models;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product  extends  BaseModel{
    private String title;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private String imageUrl;
    private int numberOfSales;
}
