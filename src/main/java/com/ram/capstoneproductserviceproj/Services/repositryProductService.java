package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.repositries.categoryRepositry;
import com.ram.capstoneproductserviceproj.repositries.productRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class repositryProductService implements  productService
{
    private productRepositry ProductRepo;
    private categoryRepositry CategoryRepo;

    @Autowired
    repositryProductService(productRepositry productRepositry,categoryRepositry categoryRepositry)
    {
        this.ProductRepo = productRepositry;
        this.CategoryRepo = categoryRepositry;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
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
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    @Override
    public List<Product> getProductsByCategory(String Category) {
        return null;
    }
}
