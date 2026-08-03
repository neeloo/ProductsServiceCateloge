package com.Neeloo.ProductsServiceCateloge.services;

import com.Neeloo.ProductsServiceCateloge.models.Product;
import com.Neeloo.ProductsServiceCateloge.repositories.CategoryRepository;
import com.Neeloo.ProductsServiceCateloge.repositories.ProductRepository;

import java.util.List;

public class ProductServiceImplement implements  ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImplement(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getsingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
