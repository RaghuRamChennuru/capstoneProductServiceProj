package com.ram.capstoneproductserviceproj.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Category extends Base
{
 //@Id
 //private long id;
 private String name;
}
