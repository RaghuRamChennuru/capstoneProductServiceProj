package com.ram.capstoneproductserviceproj.controllers;

import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.Services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController
{
    private productService ProductService;

    @Autowired
    ProductController(@Qualifier("ProductRepoService") productService productService)
    {
        this.ProductService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductForId(@PathVariable("id") Long id) throws ProductNotFoundException
    {
        ResponseEntity<Product> respProduct = new ResponseEntity<>(ProductService.getSingleProduct(id), HttpStatus.OK);
       // Product respProduct = ProductService.getSingleProduct(id);
        return respProduct;
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return ProductService.getAllProducts();
    }

    @GetMapping("/Category/{name}")
    public List<Product> getProductsByCategory(@PathVariable("name") String name)
    {
        return ProductService.getProductsByCategory(name);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product requestProduct) throws ProductNotFoundException {
        return ProductService.updateProduct(id,requestProduct);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product requestProduct)
    {
        return ProductService.replaceProduct(id, requestProduct);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product)
    {
        return ProductService.addNewProduct(product);
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
        boolean response = ProductService.deleteProduct(id);

        if(response)
        {
            return "Product Deleted";
        }

        return "Failed To Delete";
    }

}
