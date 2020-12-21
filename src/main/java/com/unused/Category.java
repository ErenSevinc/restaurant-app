package com.unused;

import com.entity.Media;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String urlToImage;

    //(
//            mappedBy = "category",
//            cascade =CascadeType.ALL
//    )
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tbl_category_product", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

    public Category() {
    }

    public Category(String name, String description, String urlToImage, List<Product> products, Media media) {
        this.name = name;
        this.description = description;
        this.urlToImage = urlToImage;
        this.products = products;
        this.media = media;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
