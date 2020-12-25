package com.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private int id;
    private String name;
    private String brand;
    private double price;
    private List<CategoriesDTO> categoriesDTOList=new ArrayList<>();
    private MediaDTO mediaDTO;

}
