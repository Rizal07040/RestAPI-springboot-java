package com.javaguides.firstproject.controller.v1.impl;

import com.javaguides.firstproject.controller.v1.BrandController;
import com.javaguides.firstproject.request.v1.CreateBrandRequest;
import com.javaguides.firstproject.request.v1.UpdateBrandRequest;
import com.javaguides.firstproject.response.BaseResponse;
import com.javaguides.firstproject.services.impl.BrandServicesImpl;
import com.javaguides.firstproject.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BrandControllerImpl implements BrandController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private BrandServicesImpl brandServices;

    @Override
    public ResponseEntity<BaseResponse> createBrand(CreateBrandRequest createBrandRequest){
        return ResponseHelper.buildOkResponse(brandServices.create(createBrandRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> getListBrand(){
        return ResponseHelper.buildOkResponse(brandServices.getListBrand());
    }

    @Override
    public ResponseEntity<BaseResponse> getBrandById(Long id) throws Exception{
        return ResponseHelper.buildOkResponse(brandServices.getOneBrand(id));
    }

    @Override
    public ResponseEntity<BaseResponse> update( UpdateBrandRequest updateBrandRequest) throws Exception{
        return ResponseHelper.buildOkResponse(brandServices.update(updateBrandRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> deleteRecursive(@PathVariable("id") Long id) throws Exception{

        BaseResponse baseResponse = new BaseResponse();
        String response = brandServices.deleteBrand(id);

        baseResponse.setData(response);
        baseResponse.setSuccess(true);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

}
