package com.ram.capstoneproductserviceproj.controllers;

import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.Services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController
{
    private productService ProductService;

    @Autowired
    ProductController(productService productService)
    {
        this.ProductService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductForId(@PathVariable("id") Long id)
    {
        Product respProduct = ProductService.getSingleProduct(id);
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

}
