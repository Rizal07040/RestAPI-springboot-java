package com.javaguides.firstproject.response.pembeli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetListPembeliResponse {
    private Long id;
    private String brand_name;
    private String product_name;
    private String product_price;
    private String qty;

}
