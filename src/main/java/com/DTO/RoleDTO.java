package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class RoleDTO {
    private int id;
    @NotNull
    private String name;
}
