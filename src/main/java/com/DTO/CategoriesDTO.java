package com.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class CategoriesDTO {
    private int id;
    private String name;
    private String description;
    private List<ProductsDTO> productsDTOList=new ArrayList<>();
    private MediaDTO mediaDTO;

}
