package com.ram.capstoneproductserviceproj.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.IncrementGenerator;

import java.util.Date;

@Getter
@Setter
//@Entity
@MappedSuperclass
public class Base
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date CreatedOn;
    private Date UpdatedOn;
    private boolean isDeleted;
}
