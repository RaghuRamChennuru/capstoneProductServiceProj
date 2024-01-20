package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.DTO.fakeStoreCategoryDTO;
import com.ram.capstoneproductserviceproj.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class fakeStoreCategoryService implements categoryService
{

    private RestTemplate restTemplate;

    @Autowired
    fakeStoreCategoryService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    private Category convertDTOintoCategory(fakeStoreCategoryDTO categoryDTO)
    {
        Category newCategory = new Category();
        newCategory.setName(categoryDTO.getName());

        return newCategory;
    }
    @Override
    public List<Category> getAllCategories()
    {
        fakeStoreCategoryDTO[] responseDTO  = restTemplate.getForObject("https://fakestoreapi.com/products/categories", fakeStoreCategoryDTO[].class);

        List<Category> categoryResp = new ArrayList<>();


        for(fakeStoreCategoryDTO ans:responseDTO)
        {
            categoryResp.add(convertDTOintoCategory(ans));
        }

        return categoryResp;
    }
}
