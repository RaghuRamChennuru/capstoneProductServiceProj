package com.ram.capstoneproductserviceproj.Inheritance.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta")
public class teachingAssistant extends user
{
    private int rating;
}
