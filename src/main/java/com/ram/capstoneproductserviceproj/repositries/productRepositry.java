package com.ram.capstoneproductserviceproj.repositries;

import com.ram.capstoneproductserviceproj.Models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepositry extends JpaRepository<Product,Long>
{

    List<Product> findAll();

    Optional<Product> getProductById(Long Id);

    Product save(Product product);
}
