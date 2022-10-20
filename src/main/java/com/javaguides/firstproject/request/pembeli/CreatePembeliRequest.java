package com.javaguides.firstproject.request.pembeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePembeliRequest {
    private Long id_productHp;
    private String qty;
}
