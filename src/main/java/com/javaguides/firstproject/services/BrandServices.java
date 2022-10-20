package com.javaguides.firstproject.services;

import com.javaguides.firstproject.request.v1.CreateBrandRequest;
import com.javaguides.firstproject.request.v1.UpdateBrandRequest;
import com.javaguides.firstproject.response.v1.GetListBrandResponse;

import java.util.List;

public interface BrandServices {

    String create(CreateBrandRequest createBrandRequest);

    String update(UpdateBrandRequest updateBrandRequest) throws Exception;

    List<GetListBrandResponse> getListBrand();

    GetListBrandResponse getOneBrand(Long id) throws Exception;

    String deleteBrand(Long id) throws Exception;

}
