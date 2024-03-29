package com.ram.capstoneproductserviceproj.controllers;

import com.ram.capstoneproductserviceproj.Models.Category;
import com.ram.capstoneproductserviceproj.Services.categoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController
{
    private categoryService service;

    @Autowired
    CategoryController(@Qualifier("CategoryFakeStore") categoryService service)
    {
        this.service = service;
    }

    @GetMapping()
    public List<String> getAllCategories()
    {
        return service.getAllCategories();
    }

}
