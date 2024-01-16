package com.ram.capstoneproductserviceproj.DTO;

import com.ram.capstoneproductserviceproj.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreProductDTO
{
    private long id;
    private String title;
    private double price;

    private String category;

    private String description;

    private String url;
}
