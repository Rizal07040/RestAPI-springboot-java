package com.javaguides.firstproject.controller.v1.impl;

import com.javaguides.firstproject.request.ProductHpRequest;
import com.javaguides.firstproject.response.ProductHpResponse;
import com.javaguides.firstproject.services.impl.ProductHpServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-hp")
public class ProductHpController {

    @Autowired
    private ProductHpServicesImpl productHpServices;

    @PostMapping
    public ProductHpResponse create(@RequestBody ProductHpRequest productHpRequest) throws Exception{
        return productHpServices.save(productHpRequest);
    }

    @PutMapping
    public ProductHpResponse update(@RequestBody ProductHpRequest productHpRequest) throws Exception{
        return productHpServices.update(productHpRequest);
    }

    @GetMapping
    public List<ProductHpResponse> findAll(){
        return productHpServices.getListProductHp();
    }
    @GetMapping("/{id}")
    public ProductHpResponse findOne(@PathVariable("id") Long id) throws Exception{
        return productHpServices.getOneProductHp(id);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productHpServices.removeOne(id);
    }

}
