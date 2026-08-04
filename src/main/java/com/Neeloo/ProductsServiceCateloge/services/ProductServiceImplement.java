package com.Neeloo.ProductsServiceCateloge.services;

import com.Neeloo.ProductsServiceCateloge.models.Category;
import com.Neeloo.ProductsServiceCateloge.models.Product;
import com.Neeloo.ProductsServiceCateloge.repositories.CategoryRepository;
import com.Neeloo.ProductsServiceCateloge.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImplement implements  ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImplement(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getsingleProduct(Long id) {
        Optional<Product>productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw  new RuntimeException("product with id :"+ id + "doesn't exit");
        }
        Product product = productOptional.get();

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
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

        Optional<Category>categoryOptional =
                categoryRepository.findByName(product.getCategory().getName());

        if(categoryOptional.isEmpty()){

        }else {
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
