package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MediaDTO {
    private int id;
    private String name;
    private byte[] fileContent;


}
