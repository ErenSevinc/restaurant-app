package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class MediaDTO implements Serializable {
    private int id;
    @NotNull
    private String name;
    private byte[] fileContent;


}
