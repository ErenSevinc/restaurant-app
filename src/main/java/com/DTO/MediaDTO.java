package com.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MediaDTO {
    private int id;
    private String name;
    private byte[] fileContent;


}
