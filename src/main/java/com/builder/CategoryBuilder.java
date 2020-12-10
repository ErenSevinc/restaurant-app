package com.builder;

import com.DTO.ProductDTO;
import com.entity.Category;
import com.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class CategoryBuilder extends Builder {
    private int id;
    private String name;
    private String description;
    private String urlToImage;
    private Set<Product> products= new HashSet<>();


    public CategoryBuilder id(int id){
        this.id=id;
        return this;
    }
    public CategoryBuilder name(String name){
        this.name=name;
        return this;
    }
    public CategoryBuilder description(String description){
        this.description=description;
        return this;
    }
    public CategoryBuilder urlToImage(String urlToImage){
        this.urlToImage=urlToImage;
        return this;
    }
    public CategoryBuilder product(Set<Product> products){
        this.products=products;
        return this;
    }

    @Override
    public Category build() {
        Category category=new Category();
        category.setId(this.id);
        category.setName(this.name);
        category.setDescription(this.description);
        category.setUrlToImage(this.urlToImage);
        category.setProducts(this.products);
        return category;
    }
}
