package com.ram.capstoneproductserviceproj.controllers;

import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.Services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product requestProduct)
    {
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
