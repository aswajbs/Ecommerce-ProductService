package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Models.Category;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
private RestTemplate restTemplate;
public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
}

@Override
   public Product getProduct(Long id){

      FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        //Convert FakeStoreProductDto to ProductService
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

   }
private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
    Product product = new Product();
    product.setId(fakeStoreProductDto.getId());
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setPrice(fakeStoreProductDto.getPrice());
    Category category = new Category();
    category.setName(fakeStoreProductDto.getCategory());
    category.setDescription(fakeStoreProductDto.getDescription());
    product.setCategory(category);
    return product;
}
    @Override
    public List<Product> getAllProducts() {
    FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject(
            "https://fakestoreapi.com/products/",FakeStoreProductDto[].class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtos);
    }
    private List<Product> convertFakeStoreProductDtoToProduct(FakeStoreProductDto[] fakeStoreProductDtos){
    List<Product> products = new ArrayList<>();
    for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
                Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
                products.add(product);
        }
    return products;
    }
}
