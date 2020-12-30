package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CategoryTableDTO {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int amount;
    @NotNull
    private MediaDTO mediaDTO;

}
