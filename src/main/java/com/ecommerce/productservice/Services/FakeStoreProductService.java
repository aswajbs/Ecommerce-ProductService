package com.ecommerce.productservice.Services;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Category;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
private RestTemplate restTemplate;
public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
}

@Override
   public Product getProduct(Long id) throws ProductNotFoundException,IdOutOfBoundException {

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
    if (Long.toString(id).length()>=3){
        throw new IdOutOfBoundException("Product "+ id+ " Out of Products Range ");
    }
    else if (fakeStoreProductDto == null){
       throw new ProductNotFoundException("Product with "+id);
   }
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

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {

    }

    @Override
    public Product updateProduct(long id, Product product) {
        long request =id;

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDto response= restTemplate.execute("https://fakestoreapi.com/Products/"+id,
                HttpMethod.PATCH, requestCallback, responseExtractor);
        return convertFakeStoreProductDtoToProduct(response);

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
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
