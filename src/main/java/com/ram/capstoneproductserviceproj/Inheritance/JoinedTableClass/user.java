package com.ram.capstoneproductserviceproj.Inheritance.JoinedTableClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class user
{
    @Id
    private long id;
    private String name;

}
