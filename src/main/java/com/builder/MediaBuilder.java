package com.builder;

import com.entity.Media;

public class MediaBuilder extends Builder{
    private int id;
    private String name;
    private byte[] fileContext;

    public MediaBuilder name(String name){
        this.name=name;
        return this;
    }
    public MediaBuilder fileContext(byte[] fileContext){
        this.fileContext=fileContext;
        return this;
    }


    public MediaBuilder id(int id){
        this.id=id;
        return this;
    }

    @Override
    public Media build() {
        Media media=new Media();
        media.setId(this.id);
        media.setName(this.name);
        media.setFileContent(this.fileContext);

        return media;
    }
}
