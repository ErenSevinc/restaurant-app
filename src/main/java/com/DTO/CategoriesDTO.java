package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CategoriesDTO implements Serializable {
    private int id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private List<ProductsDTO> productsDTOList=new ArrayList<>();
    @NotNull
    private MediaDTO mediaDTO;

}
