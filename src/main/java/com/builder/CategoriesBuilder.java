package com.builder;

import com.entity.Media;
import com.entity.Categories;
import com.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class CategoriesBuilder extends Builder {
    private int id;
    private String name;
    private String description;
    private List<Products> products=new ArrayList<>();
    private Media media;

    public CategoriesBuilder id(int id){
        this.id=id;
        return this;
    }
    public CategoriesBuilder name(String name){
        this.name=name;
        return this;
    }
    public CategoriesBuilder description(String description){
        this.description=description;
        return this;
    }
    public CategoriesBuilder products(List<Products> products){
        this.products=products;
        return this;
    }
    public CategoriesBuilder media(Media media){
        this.media=media;
        return this;
    }


    @Override
    public Categories build() {
        Categories categories=new Categories();
        categories.setId(this.id);
        categories.setName(this.name);
        categories.setDescription(this.description);
        categories.setProducts(this.products);
        categories.setMedia(this.media);

        return null;
    }
}
