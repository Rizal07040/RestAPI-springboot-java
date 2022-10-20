package com.javaguides.firstproject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHpRequest {
    private Long id_brand;
    private Long id;
    private String name;
    private String harga;
}
