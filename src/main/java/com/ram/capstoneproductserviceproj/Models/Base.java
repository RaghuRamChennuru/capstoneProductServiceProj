package com.ram.capstoneproductserviceproj.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@Entity
@MappedSuperclass
public class Base
{
    @Id
    private long id;
    private Date CreatedOn;
    private Date UpdatedOn;
    private boolean isDeleted;
}
