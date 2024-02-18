package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import com.ram.capstoneproductserviceproj.Models.Category;
import com.ram.capstoneproductserviceproj.Models.Product;

import java.util.List;

public interface productService
{
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    Product updateProduct(Long id,Product product) throws ProductNotFoundException;

    Product replaceProduct(Long id,Product product);

    Product addNewProduct(Product product);

    List<Product> getAllProducts();

    boolean deleteProduct(Long id);
    List<Product> getProductsByCategory(String Category);


}
