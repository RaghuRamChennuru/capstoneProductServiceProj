package com.ram.capstoneproductserviceproj.Inheritance.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
public class teachingAssistant extends user
{
    @Id
    private long id;
    private int rating;
}
