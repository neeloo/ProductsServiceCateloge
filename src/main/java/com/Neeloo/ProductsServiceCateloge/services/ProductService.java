package com.Neeloo.ProductsServiceCateloge.services;

import com.Neeloo.ProductsServiceCateloge.models.Product;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product getsingleProduct(Long id);

    List<Product> getAllProducts();

    Product  updateProduct(Long id , Product product);

    Product replaceProduct(Long id , Product product);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long id);

}
