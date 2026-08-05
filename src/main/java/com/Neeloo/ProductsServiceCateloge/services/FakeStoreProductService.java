package com.Neeloo.ProductsServiceCateloge.services;


import com.Neeloo.ProductsServiceCateloge.dtos.FakeStoreProductDto;
import com.Neeloo.ProductsServiceCateloge.models.Category;
import com.Neeloo.ProductsServiceCateloge.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStorePRoductDtoProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return  product;
    }


    @Override
    public Product getsingleProduct(Long id) {
        ResponseEntity<FakeStoreProductDto>productDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id ,
                FakeStoreProductDto.class
        );
        if(productDto.getStatusCode() != HttpStatusCode.valueOf(200)){

        }
        if(productDto == null){
            throw  new RuntimeException("product id"+ id + "does not exit");
        }
        return convertFakeStorePRoductDtoProduct(productDto.getBody());
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[]responce = restTemplate.getForObject(
                "https://fakestoreapi.com/products",   /// get all product api
                FakeStoreProductDto[].class
        );

        List<Product> ans = new ArrayList<>();

        for(FakeStoreProductDto dto : responce){
            ans.add(convertFakeStorePRoductDtoProduct(dto));
        }
        return ans;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImageUrl());
        dto.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(dto , FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responce =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class , restTemplate.getMessageConverters());

        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products/" + id , HttpMethod.PUT ,  requestCallback,responce);

        return convertFakeStorePRoductDtoProduct(fakeStoreProductDto);
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
