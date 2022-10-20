package com.javaguides.firstproject.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductItemResponse {
    String name;
    String name_item;
    String describtion;
    double price;
}
