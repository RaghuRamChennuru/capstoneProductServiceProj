package com.ram.capstoneproductserviceproj.Inheritance.SingleTableClass;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class mentor extends user
{
    private int qualification;
}
