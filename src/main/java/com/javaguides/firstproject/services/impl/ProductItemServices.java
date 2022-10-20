package com.javaguides.firstproject.services.impl;

import com.javaguides.firstproject.model.entities.Product;
import com.javaguides.firstproject.model.entities.ProductItem;
import com.javaguides.firstproject.model.repos.ProductItemRepo;
import com.javaguides.firstproject.model.repos.ProductRepo;
import com.javaguides.firstproject.request.CreateProductItemRequest;
import com.javaguides.firstproject.response.CreateProductItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductItemServices {

    @Autowired
    private ProductItemRepo productItemRepo;
    @Autowired
    private ProductRepo productRepo;


    public CreateProductItemResponse save(CreateProductItemRequest createProductItemRequest) throws Exception {
        Product products = productRepo.findById(createProductItemRequest.getProduct_id()).
                orElseThrow(() -> new Exception("asdasdas"));

        ProductItem productItem = ProductItem.builder()
                .product(products)
                .name_item(createProductItemRequest.getName_item())
                .describtion(createProductItemRequest.getDescribtion())
                .price(createProductItemRequest.getPrice())
                .build();

        productItem = productItemRepo.save(productItem);
        return CreateProductItemResponse.builder()
                .name(productItem.getProduct().getName())
                .name_item(productItem.getName_item())
                .build();
    }

    public ProductItem findOne(Long id){
        Optional<ProductItem> productItem = productItemRepo.findById(id);
        if(!productItem.isPresent()){
            return null;
        }
        return productItemRepo.findById(id).get();
    }

    public Iterable<ProductItem> findAll(){
        return productItemRepo.findAll();
    }

    public void removeOne(Long id){
        productItemRepo.deleteById(id);
    }


}
