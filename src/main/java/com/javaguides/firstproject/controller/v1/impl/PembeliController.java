package com.javaguides.firstproject.controller.v1.impl;

import com.javaguides.firstproject.request.pembeli.CreatePembeliRequest;
import com.javaguides.firstproject.request.pembeli.UpdatePembeliRequest;
import com.javaguides.firstproject.response.pembeli.CreatePembeliResponse;
import com.javaguides.firstproject.response.pembeli.GetListPembeliResponse;
import com.javaguides.firstproject.response.pembeli.UpdatePembeliResponse;
import com.javaguides.firstproject.services.impl.PembeliServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {

    @Autowired
    private PembeliServicesImpl pembeliServices;

    @PostMapping
    public CreatePembeliResponse create(@RequestBody CreatePembeliRequest createPembeliRequest) throws Exception{
        return pembeliServices.save(createPembeliRequest);
    }

    @GetMapping
    public List<GetListPembeliResponse> findAll(){
        return pembeliServices.GetListPembeli();
    }

    @PutMapping
    public UpdatePembeliResponse update(@RequestBody UpdatePembeliRequest updatePembeliRequest) throws  Exception{
        return pembeliServices.update(updatePembeliRequest);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        pembeliServices.removeOne(id);
    }
}
