package com.javaguides.firstproject.controller.v1;

import com.javaguides.firstproject.request.v1.CreateBrandRequest;
import com.javaguides.firstproject.request.v1.UpdateBrandRequest;
import com.javaguides.firstproject.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/brand")
public interface BrandController {

    @PostMapping
    ResponseEntity<BaseResponse> createBrand(@RequestBody CreateBrandRequest createBrandRequest);

    @PutMapping
    ResponseEntity<BaseResponse> update(@RequestBody UpdateBrandRequest updateBrandRequest) throws Exception;

    @GetMapping
    ResponseEntity<BaseResponse> getListBrand();

    @GetMapping("/{id}")
    ResponseEntity<BaseResponse> getBrandById(@PathVariable("id") Long id) throws Exception;

    @DeleteMapping("/{id}")
    ResponseEntity<BaseResponse> deleteRecursive(@PathVariable("id") Long id) throws Exception;
}

