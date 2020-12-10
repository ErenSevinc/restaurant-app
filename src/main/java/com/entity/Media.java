package com.entity;

import com.builder.MediaBuilder;

import javax.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 1000000)
    private byte[] fileContent;


    public Media() {
    }

    public Media(int id, String name, byte[] fileContent) {
        this.id = id;
        this.name = name;
        this.fileContent = fileContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }


}
