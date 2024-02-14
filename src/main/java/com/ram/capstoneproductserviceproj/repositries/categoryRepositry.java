package com.ram.capstoneproductserviceproj.repositries;

import com.ram.capstoneproductserviceproj.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepositry extends JpaRepository<Category,Long> {
}
