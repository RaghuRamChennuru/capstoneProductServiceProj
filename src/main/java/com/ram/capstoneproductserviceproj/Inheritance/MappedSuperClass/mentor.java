package com.ram.capstoneproductserviceproj.Inheritance.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name  = "msc_mentor")
public class mentor extends user
{
    private int qualification;
}
