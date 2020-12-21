package com.builder;

import com.entity.Media;
import com.entity.Categories;
import com.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsBuilder extends Builder {
    private int id;
    private String name;
    private String brand;
    private double price;
    private List<Categories> categories=new ArrayList<>();
    private Media media;

    public ProductsBuilder id(int id){
        this.id=id;
        return this;
    }
    public ProductsBuilder name(String name){
        this.name=name;
        return this;
    }
    public ProductsBuilder brand(String brand){
        this.brand=brand;
        return this;
    }
    public ProductsBuilder price(double price){
        this.price=price;
        return this;
    }
    public ProductsBuilder categoriesList(List<Categories> categories){
        this.categories=categories;
        return this;
    }
    public ProductsBuilder media(Media media){
        this.media=media;
        return this;
    }

    @Override
    public Object build() {
        Products products=new Products();
        products.setId(this.id);
        products.setName(this.name);
        products.setBrand(this.brand);
        products.setPrice(this.price);
        products.setCategories(this.categories);
        products.setMedia(this.media);

        return products;
    }
}
