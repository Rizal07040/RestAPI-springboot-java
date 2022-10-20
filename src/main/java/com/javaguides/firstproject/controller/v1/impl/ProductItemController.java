package com.javaguides.firstproject.controller.v1.impl;

import com.javaguides.firstproject.model.entities.ProductItem;
import com.javaguides.firstproject.request.CreateProductItemRequest;
import com.javaguides.firstproject.services.impl.ProductItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-item")
public class ProductItemController {

    @Autowired
    private ProductItemServices productItemServices;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductItemRequest productItem) throws Exception{
        return ResponseEntity.ok(productItemServices.save(productItem));
    }

    @GetMapping
    public Iterable<ProductItem> findAll(){
        return productItemServices.findAll();
    }

    @GetMapping("/{id}")
    public ProductItem findOne(@PathVariable("id") Long id){
        return productItemServices.findOne(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CreateProductItemRequest productItem) throws Exception{
        return ResponseEntity.ok(productItemServices.save(productItem));
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productItemServices.removeOne(id);
    }

}
