package com.javaguides.firstproject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductItemRequest {
    private Long product_id;
    private String name_item;
    private String describtion;
    private double price;
}
