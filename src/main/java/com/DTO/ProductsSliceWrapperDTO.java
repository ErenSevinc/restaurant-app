package com.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductsSliceWrapperDTO {
    private List<ProductsDTO> productsDTOList;
    private boolean hasNext;
}
