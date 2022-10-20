package com.javaguides.firstproject.services.impl;

import com.javaguides.firstproject.model.entities.Brand;
import com.javaguides.firstproject.model.repos.BrandRepo;
import com.javaguides.firstproject.request.v1.CreateBrandRequest;
import com.javaguides.firstproject.request.v1.UpdateBrandRequest;
import com.javaguides.firstproject.response.v1.GetListBrandResponse;
import com.javaguides.firstproject.services.BrandServices;
import com.javaguides.firstproject.util.exceptions.BadRequestException;
import com.javaguides.firstproject.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandServicesImpl implements BrandServices {

    @Autowired
    private BrandRepo brandRepo;

    public String create(CreateBrandRequest createBrandRequest){

        Brand brand = Brand.builder()
                .name(createBrandRequest.getName())
                .description(createBrandRequest.getDescription())
                .build();
                brandRepo.save(brand);

        return "Brand Berhasil di Tambahkan !!!";
    }

    public String update(UpdateBrandRequest updateBrandRequest){
        Brand brand = brandRepo.findById(updateBrandRequest.getId()).
                orElseThrow(() -> new NotFoundException(""));

        brand.setName(updateBrandRequest.getName());
        brand.setDescription(brand.getDescription());
        brandRepo.save(brand);
        return "Brand Berhasil di Update";

    }
    public GetListBrandResponse getOneBrand(Long id){
        Brand brand = brandRepo.findById(id).orElseThrow(() -> new NotFoundException(""));

        return GetListBrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build();
    }

    public List<GetListBrandResponse> getListBrand(){
        List<Brand> listBrand = brandRepo.findAll();

        return listBrand.stream().map(brand -> GetListBrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build()).collect(Collectors.toList());
    }

    public String deleteBrand(Long id){
        Optional<Brand> deleteBrand = brandRepo.findById(id);
        if (deleteBrand.isEmpty()) {
            throw new BadRequestException("Brand Tidak Valid");
        }

        brandRepo.deleteById(id);
        return "Brand berhasil di Hapus !!!";
    }

}
