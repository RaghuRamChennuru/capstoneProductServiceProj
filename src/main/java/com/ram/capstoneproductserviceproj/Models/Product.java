package com.ram.capstoneproductserviceproj.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product extends Base
{
   // @Id
    //private long id;
    private String title;
    private Double price;

    @ManyToOne
    private Category category;

    private String description;

    private String url;

}
