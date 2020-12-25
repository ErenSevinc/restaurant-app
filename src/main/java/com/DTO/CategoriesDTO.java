package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CategoriesDTO {
    private int id;
    private String name;
    private String description;
    private List<ProductsDTO> productsDTOList=new ArrayList<>();
    private MediaDTO mediaDTO;

}
