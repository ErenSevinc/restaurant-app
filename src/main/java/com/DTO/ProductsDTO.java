package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductsDTO {
    private int id;
    private String name;
    private String brand;
    private double price;
    private List<CategoriesDTO> categoriesDTOList=new ArrayList<>();
    private MediaDTO mediaDTO;

}
