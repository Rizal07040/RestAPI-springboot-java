package com.javaguides.firstproject.request.pembeli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePembeliRequest {
    private Long id;
    private String qty;
}
