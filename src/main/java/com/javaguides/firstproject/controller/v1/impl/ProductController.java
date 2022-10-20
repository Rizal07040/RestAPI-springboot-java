package com.javaguides.firstproject.controller.v1.impl;

import com.javaguides.firstproject.model.entities.Product;
import com.javaguides.firstproject.services.impl.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productServices.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productServices.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productServices.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productServices.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productServices.removeOne(id);
    }
}
