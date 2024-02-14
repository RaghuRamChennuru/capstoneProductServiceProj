package com.ram.capstoneproductserviceproj.Inheritance.JoinedTableClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")

public class teachingAssistant extends user
{

   // @Id
  //  private long ta_id;
    //@JoinColumn(name = "user_id",referencedColumnName = "id")
    private int rating;
}
