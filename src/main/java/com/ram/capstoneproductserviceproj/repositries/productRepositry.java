package com.ram.capstoneproductserviceproj.repositries;

import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.repositries.Projections.ProductProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepositry extends JpaRepository<Product,Long>
{

    List<Product> findAll();


    // Declared Query
    Optional<Product> getProductById(Long Id);

    Product save(Product product);

    //Hibernate SQL Query
    @Query("Select p From Product p where p.price < 100")
    List<Product> getAllProductsLessThan100();


    // Native Sql Query
    @Query(value ="Select * from product p where p.description Like '%Rose%' ",nativeQuery = true)
    List<Product> doSomething1();



    // HQL with Param
    @Query("Select p from Product p where p.id =:ID")
    Product getProductDetailsById(@Param("ID") long id);


    //Projections Used
    @Query(value = "Select p.id as id,p.description as description from product p where p.title =:title",nativeQuery = true)
    ProductProjection getProductDetailsByTitle(@Param("title") String title);
}
