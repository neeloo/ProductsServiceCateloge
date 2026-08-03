package com.Neeloo.ProductsServiceCateloge.services;

import com.Neeloo.ProductsServiceCateloge.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getsingleProduct(Long id);

    List<Product> getAllProducts();

}
