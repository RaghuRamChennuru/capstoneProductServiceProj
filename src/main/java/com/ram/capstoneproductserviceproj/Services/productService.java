package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.Models.Product;

import java.util.List;

public interface productService
{
    Product getSingleProduct(Long id);

    Product updateProduct(Long id,Product product);

    Product replaceProduct(Long id,Product product);

    Product addNewProduct(Product product);

    List<Product> getAllProducts();

    boolean deleteProduct(Product product);


}
