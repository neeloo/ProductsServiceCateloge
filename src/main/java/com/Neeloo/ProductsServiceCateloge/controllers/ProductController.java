package com.Neeloo.ProductsServiceCateloge.controllers;


import com.Neeloo.ProductsServiceCateloge.commons.AuthenticationCommons;
import com.Neeloo.ProductsServiceCateloge.models.Product;
import com.Neeloo.ProductsServiceCateloge.services.ProductService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    //private AuthenticationCommons authenticationCommons;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product>products = productService.getAllProducts();
        List<Product>finalProduct = new ArrayList<>();

        for(Product p :products){
            p.setTitle("Hello"+ p.getTitle());
            finalProduct.add(p);
        }
        ResponseEntity<List<Product>>ans = new ResponseEntity<>(
                finalProduct , HttpStatus.FORBIDDEN
        );

        return ans;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                productService.getsingleProduct(id),HttpStatus.OK
        );

    }

    @PostMapping()
    public Product addProducts(@RequestBody Product product){
        return  productService.addNewProduct(product);
    }

    //@PatchMapping("/{id}")
}


