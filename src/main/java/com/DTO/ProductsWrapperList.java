package com.DTO;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsWrapperList {
    private List<ProductsDTO> productsDTOList;
    private int totalElements;
}
