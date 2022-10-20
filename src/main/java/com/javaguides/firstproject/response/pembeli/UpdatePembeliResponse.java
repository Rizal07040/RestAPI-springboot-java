package com.javaguides.firstproject.response.pembeli;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePembeliResponse {
    private Long id;
    private String qty;
}
