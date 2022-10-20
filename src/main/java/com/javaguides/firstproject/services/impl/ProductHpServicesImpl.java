package com.javaguides.firstproject.services.impl;

import com.javaguides.firstproject.model.entities.Brand;
import com.javaguides.firstproject.model.entities.ProductHp;
import com.javaguides.firstproject.model.repos.BrandRepo;
import com.javaguides.firstproject.model.repos.ProductHpRepo;
import com.javaguides.firstproject.request.ProductHpRequest;
import com.javaguides.firstproject.response.ProductHpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductHpServicesImpl {

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private ProductHpRepo productHpRepo;

    public ProductHpResponse save(ProductHpRequest productHpRequest) throws Exception {
        Brand brands = brandRepo.findById(productHpRequest.getId_brand()).
                orElseThrow(() -> new Exception("Id Not Found"));

        ProductHp productHp = ProductHp.builder()
                .brand(brands)
                .name(productHpRequest.getName())
                .harga(productHpRequest.getHarga())
                .build();
        productHp = productHpRepo.save(productHp);

        return ProductHpResponse.builder()
                .id(productHp.getId())
                .name_brand(productHp.getBrand().getName())
                .name(productHp.getName())
                .harga(productHp.getHarga())
                .build();
    }

    public ProductHpResponse update(ProductHpRequest productHpRequest) throws Exception {
        ProductHp productHp = productHpRepo.findById(productHpRequest.getId())
                .orElseThrow(() -> new Exception("Id Not Found"));
        productHp.setName(productHpRequest.getName());
        productHp.setHarga(productHpRequest.getHarga());
        productHpRepo.save(productHp);
        return ProductHpResponse.builder()
                .id(productHp.getId())
                .name_brand(productHp.getBrand().getName())
                .name(productHp.getName())
                .harga(productHp.getHarga())
                .build();
    }
    public List<ProductHpResponse> getListProductHp(){
        List<ProductHp> all = productHpRepo.findAll();

        return all.stream().map(productHp -> ProductHpResponse.builder()
                .id(productHp.getId())
                .name_brand(productHp.getBrand().getName())
                .name(productHp.getName())
                .harga(productHp.getHarga())
                .build()).collect(Collectors.toList());
    }
    public ProductHpResponse getOneProductHp(Long id) throws  Exception{
        ProductHp productHp = productHpRepo.findById(id).orElseThrow(() -> new Exception("Id Not Found"));

        return ProductHpResponse.builder()
                .id(productHp.getId())
                .name_brand(productHp.getBrand().getName())
                .name(productHp.getName())
                .harga(productHp.getHarga())
                .build();
    }

    public void removeOne(Long id){
        productHpRepo.deleteById(id);
    }
}
