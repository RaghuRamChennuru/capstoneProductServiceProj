package com.ram.capstoneproductserviceproj.Inheritance.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class mentor extends  user
{
    @Id
    private long id;
    private int qualification;
}
