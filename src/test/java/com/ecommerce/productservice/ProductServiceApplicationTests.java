package com.ecommerce.productservice;

import com.ecommerce.productservice.Projections.ProductsbyIdName;
import com.ecommerce.productservice.Repositories.CategoryRepo;
import com.ecommerce.productservice.Repositories.Productrepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
    @Autowired
 private Productrepo productrepo;
    @Autowired
    private CategoryRepo categoryRepo;


   @Test
   void contextLoads() {
   }

   @Test
   void testDBQueries() {
       ProductsbyIdName productsbyIdName = productrepo.findProductsbyIdName(3L);

          System.out.println(productsbyIdName.getId() + " " + productsbyIdName.getTitle());
       }
//


}
