package com.DTO;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO implements Serializable {
    private int id;
    @NotNull
    private String name;
    private String brand;
    @NotNull
    private double price;
    @NotNull
    private List<CategoriesDTO> categoriesDTOList=new ArrayList<>();
    @NotNull
    private MediaDTO mediaDTO;

}
