package com.javaguides.firstproject.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductHpResponse {
    Long id;
    String name_brand;
    String name;
    String harga;
}
