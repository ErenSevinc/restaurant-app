package com.builder.DTOBuilder;

import com.DTO.MediaDTO;
import com.builder.Builder;

public class MediaDTOBuilder extends Builder {
    private int id;
    private String name;
    private byte[] fileContent;

    @Override
    public MediaDTO build() {
        MediaDTO mediaDTO=new MediaDTO();
        mediaDTO.setId(this.id);
        mediaDTO.setName(this.name);
        mediaDTO.setFileContent(this.fileContent);
        return mediaDTO;
    }
    public MediaDTOBuilder fileContent(byte[] fileContent){
        this.fileContent=fileContent;
        return this;
    }
    public MediaDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public MediaDTOBuilder name(String name){
        this.name=name;
        return this;
    }
}
