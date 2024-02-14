package com.ram.capstoneproductserviceproj.Inheritance.JoinedTableClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class teachingAssistant extends user
{
    @Id
    private long id;
    private int rating;
}
