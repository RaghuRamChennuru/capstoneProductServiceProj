package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import com.ram.capstoneproductserviceproj.Models.Category;
import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.repositries.categoryRepositry;
import com.ram.capstoneproductserviceproj.repositries.productRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProductRepoService")
//@Primary
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
    public Product getSingleProduct(Long id) throws ProductNotFoundException
    {
        Optional<Product> responseProduct = ProductRepo.getProductById(id);

        if(responseProduct.isEmpty())
        {
            throw new ProductNotFoundException("Product With Id Not Found");
        }

        return responseProduct.get();
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException
    {

        Optional<Product> respProduct = ProductRepo.findById(id);


        if(respProduct.isEmpty())
        {
            throw new ProductNotFoundException("Product With The Id Not Found");
        }

        Product productObject = respProduct.get();

        if(product.getPrice() != null)
        {
            productObject.setPrice(product.getPrice());
        }

        if(product.getDescription() != null)
        {
            productObject.setDescription(product.getDescription());
        }

        if(product.getTitle() != null)
        {
            productObject.setTitle(product.getTitle());
        }

        if(product.getUrl() != null)
        {
            productObject.setUrl(product.getUrl());
        }

        if(product.getCategory() != null)
        {
            Optional<Category> respCategory = CategoryRepo.getCategoriesById(product.getCategory().getId());

            Category newCategory = null;

            if(respCategory.isEmpty())
            {
                 newCategory = CategoryRepo.save(product.getCategory());
            }
            else {
                newCategory = respCategory.get();
            }

            product.setCategory(newCategory);
        }

        //product.setId(id);

        Product updatedProduct = addNewProduct(product);

        return updatedProduct;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product)
    {
        Category ansCategory = product.getCategory();

        Category newCategory = null;

        if(ansCategory.getId() != null)
        {
            Optional<Category> categoryResp  = CategoryRepo.getCategoriesById(ansCategory.getId());

            if(categoryResp.isEmpty())
            {
                newCategory = CategoryRepo.save(ansCategory);
            }

        }
        else
        {
            newCategory = CategoryRepo.save(ansCategory);
        }

        product.setCategory(newCategory);

        Product newProduct = ProductRepo.save(product);

        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> response = ProductRepo.findAll();

        return response;
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
