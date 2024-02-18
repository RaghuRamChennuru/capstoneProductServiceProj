package com.ram.capstoneproductserviceproj.Services;

import com.ram.capstoneproductserviceproj.repositries.categoryRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryRepoService")
public class repositryCategoryService implements categoryService
{
    private categoryRepositry CategoryRepo;

    @Autowired
    repositryCategoryService(categoryRepositry categoryRepositry)
    {
        this.CategoryRepo = categoryRepositry;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }
}
