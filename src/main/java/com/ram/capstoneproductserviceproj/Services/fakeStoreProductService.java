package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.DTO.fakeStoreProductDTO;
import com.ram.capstoneproductserviceproj.Models.Category;
import com.ram.capstoneproductserviceproj.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class fakeStoreProductService implements  productService
{
    private RestTemplate restTemplate;

    @Autowired
    public fakeStoreProductService(RestTemplate restTemplate )
    {
        this.restTemplate = restTemplate;
    }

    private Product convertDTOIntoProduct(fakeStoreProductDTO response)
    {
        Product product = new Product();
        product.setId(response.getId());
        product.setPrice(response.getPrice());
        product.setDescription(response.getDescription());
        product.setTitle(response.getTitle());
        product.setUrl(response.getUrl());

        Category category = new Category();
        category.setName(response.getCategory());

        product.setCategory(category);

        return product;
    }

    @Override
    public Product getSingleProduct(Long id)
    {
       fakeStoreProductDTO response =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, fakeStoreProductDTO.class);

       Product productResp = convertDTOIntoProduct(response);

        return productResp;
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
    public List<Product> getAllProducts()
    {
       fakeStoreProductDTO[] response= restTemplate.getForObject("https://fakestoreapi.com/products", fakeStoreProductDTO[].class);

       List<Product> answer = new ArrayList<>();

       for(fakeStoreProductDTO ans:response)
        {
            answer.add(convertDTOIntoProduct(ans));
        }

        return answer;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> getProductsByCategory(String Category) {
        return null;
    }
}
