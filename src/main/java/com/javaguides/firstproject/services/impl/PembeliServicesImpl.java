package com.javaguides.firstproject.services.impl;

import com.javaguides.firstproject.model.entities.Pembeli;
import com.javaguides.firstproject.model.entities.ProductHp;
import com.javaguides.firstproject.model.repos.PembeliRepo;
import com.javaguides.firstproject.model.repos.ProductHpRepo;
import com.javaguides.firstproject.request.pembeli.CreatePembeliRequest;
import com.javaguides.firstproject.request.pembeli.UpdatePembeliRequest;
import com.javaguides.firstproject.response.pembeli.CreatePembeliResponse;
import com.javaguides.firstproject.response.pembeli.GetListPembeliResponse;
import com.javaguides.firstproject.response.pembeli.UpdatePembeliResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PembeliServicesImpl {

    @Autowired
    private ProductHpRepo productHpRepo;

    @Autowired
    private PembeliRepo pembeliRepo;

    public CreatePembeliResponse save(CreatePembeliRequest createPembeliRequest) throws Exception {
        ProductHp productHps = productHpRepo.findById(createPembeliRequest.getId_productHp()).
                orElseThrow(() -> new Exception("Id Not Found"));

        Pembeli pembeli = Pembeli.builder()
                .productHp(productHps)
                .qty(createPembeliRequest.getQty())
                .build();
        pembeli = pembeliRepo.save(pembeli);

        return CreatePembeliResponse.builder()
                .id(pembeli.getId())
                .name_productHp(pembeli.getProductHp().getName())
                .qty(pembeli.getQty())
                .build();
    }
    public UpdatePembeliResponse update(UpdatePembeliRequest updatePembeliRequest) throws Exception {
        Pembeli pembeli = pembeliRepo.findById(updatePembeliRequest.getId())
                .orElseThrow(() -> new Exception("Id Not Found"));
        pembeli.setQty(updatePembeliRequest.getQty());
        pembeliRepo.save(pembeli);

        return UpdatePembeliResponse.builder()
                .id(pembeli.getId())
                .qty(pembeli.getQty())
                .build();
    }
    public List<GetListPembeliResponse> GetListPembeli(){
        List<Pembeli> all = pembeliRepo.findAll();

        return all.stream().map(pembeli -> GetListPembeliResponse.builder()
                .id(pembeli.getId())
                .brand_name(pembeli.getProductHp().getBrand().getName())
                .product_name(pembeli.getProductHp().getName())
                .product_price(pembeli.getProductHp().getHarga())
                .qty(pembeli.getQty())
                .build()).collect(Collectors.toList());
    }
    public void removeOne(Long id){
        pembeliRepo.deleteById(id);
    }
}
