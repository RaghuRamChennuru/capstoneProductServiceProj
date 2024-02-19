package com.ram.capstoneproductserviceproj;

import com.ram.capstoneproductserviceproj.Models.Product;
import com.ram.capstoneproductserviceproj.repositries.Projections.ProductProjection;
import com.ram.capstoneproductserviceproj.repositries.productRepositry;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CapstoneProductServiceProjApplicationTests {

	@Autowired
	private productRepositry productRepo;


	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void doTesting()
	{
		List<Product> resp =  productRepo.getAllProductsLessThan100();

		List<Product> resp1 = productRepo.doSomething1();

		Product  resp3 = productRepo.getProductDetailsById(1L);

		//Projections
		ProductProjection resp4 = productRepo.getProductDetailsByTitle("Braclet New");

		System.out.println(resp4.getid() + " - " + resp4.getdescription());
	}

}
