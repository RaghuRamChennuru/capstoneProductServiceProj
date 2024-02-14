package com.ram.capstoneproductserviceproj.Inheritance.JoinedTableClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class mentor extends user
{
    //   @JoinColumn(name = "user_id",referencedColumnName = "id")
   // @Id
    //private long id;
    private int qualification;
}
