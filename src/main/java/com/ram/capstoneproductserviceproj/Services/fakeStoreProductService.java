package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.DTO.fakeStoreProductDTO;
import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import com.ram.capstoneproductserviceproj.Models.Category;
import com.ram.capstoneproductserviceproj.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
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
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //int a = 1/0;

       fakeStoreProductDTO response =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, fakeStoreProductDTO.class);

       if(response == null)
       {
           throw new ProductNotFoundException("Product With Selected Id Not Found");
       }

       Product productResp = convertDTOIntoProduct(response);

        return productResp;
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        fakeStoreProductDTO dtoObject = new fakeStoreProductDTO();
        dtoObject.setDescription(product.getDescription());
        dtoObject.setCategory(product.getCategory().getName());
        dtoObject.setUrl(product.getUrl());
        dtoObject.setTitle(product.getTitle());
        dtoObject.setPrice(product.getPrice());
        dtoObject.setId(id);


        RequestCallback requestCallback = restTemplate.httpEntityCallback(dtoObject,fakeStoreProductDTO.class);

        HttpMessageConverterExtractor<fakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(fakeStoreProductDTO.class, restTemplate.getMessageConverters());

        fakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,requestCallback,responseExtractor);


        return convertDTOIntoProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        fakeStoreProductDTO dtoObject = new fakeStoreProductDTO();
        dtoObject.setDescription(product.getDescription());
        dtoObject.setCategory(product.getCategory().getName());
        dtoObject.setUrl(product.getUrl());
        dtoObject.setTitle(product.getTitle());
        dtoObject.setPrice(product.getPrice());
        dtoObject.setId(id);


        RequestCallback requestCallback = restTemplate.httpEntityCallback(dtoObject,fakeStoreProductDTO.class);

        HttpMessageConverterExtractor<fakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(fakeStoreProductDTO.class, restTemplate.getMessageConverters());

        fakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.POST,requestCallback,responseExtractor);


        return convertDTOIntoProduct(response);
    }

    @Override
    public Product addNewProduct(Product product) {
        fakeStoreProductDTO dtoObject = new fakeStoreProductDTO();
        dtoObject.setDescription(product.getDescription());
        dtoObject.setCategory(product.getCategory().getName());
        dtoObject.setUrl(product.getUrl());
        dtoObject.setTitle(product.getTitle());
        dtoObject.setPrice(product.getPrice());


        fakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",dtoObject, fakeStoreProductDTO.class);


        return convertDTOIntoProduct(response);
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
    public boolean deleteProduct(Long id) {

        fakeStoreProductDTO dtoObject = new fakeStoreProductDTO();
        dtoObject.setId(id);


        RequestCallback requestCallback = restTemplate.httpEntityCallback(dtoObject,fakeStoreProductDTO.class);

        HttpMessageConverterExtractor<fakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(fakeStoreProductDTO.class, restTemplate.getMessageConverters());


        fakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE,requestCallback,responseExtractor);




        return false;
    }

    @Override
    public List<Product> getProductsByCategory(String Category)
    {
        fakeStoreProductDTO[] responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products/category/"+Category, fakeStoreProductDTO[].class);

        List<Product> response = new ArrayList<>();

        for(fakeStoreProductDTO ans:responseDTO)
        {
            response.add(convertDTOIntoProduct(ans));
        }

        return response;
    }
}
