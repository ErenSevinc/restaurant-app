package com.unused;

import com.DTO.MediaDTO;
import com.unused.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private int id;
    private String name;
    private String description;
    private String urlToImage;
    private List<Product> products= new ArrayList<>();
    private MediaDTO mediaDTO;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getUrlToImage() {
//        return urlToImage;
//    }
//
//    public void setUrlToImage(String urlToImage) {
//        this.urlToImage = urlToImage;
//    }


    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public MediaDTO getMediaDTO() {
        return mediaDTO;
    }

    public void setMedia(MediaDTO mediaDTO) {
        this.mediaDTO = mediaDTO;
    }
}
