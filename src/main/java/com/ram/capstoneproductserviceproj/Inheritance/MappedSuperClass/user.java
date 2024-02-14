package com.ram.capstoneproductserviceproj.Inheritance.MappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class user
{
    @Id
    private long id;
    private String name;

}
