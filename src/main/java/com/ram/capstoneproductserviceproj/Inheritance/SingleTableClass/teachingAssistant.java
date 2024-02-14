package com.ram.capstoneproductserviceproj.Inheritance.SingleTableClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class teachingAssistant extends user
{
    private int rating;
}
