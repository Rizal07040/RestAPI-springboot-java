package com.javaguides.firstproject.response.pembeli;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePembeliResponse {
    Long id;
    String name_productHp;
    String qty;
}
