//package com.builder;
//
//import com.entity.Category;
//import com.entity.Product;
//
//import java.util.Set;
//
//public class ProductBuilder extends Builder{
//    private int id;
//    private String name;
//    private String brand;
//    private double price;
//    private String productCategory;
//    private String urlToImage;
//    private Set<Category> categories;
//
//    public  ProductBuilder id(int id){
//        this.id=id;
//        return this;
//    }
//    public ProductBuilder name(String name){
//        this.name=name;
//        return this;
//    }
//    public ProductBuilder brand(String brand){
//        this.brand=brand;
//        return this;
//    }
//    public ProductBuilder price(double price){
//        this.price=price;
//        return this;
//    }
//    public ProductBuilder productCategory(String productCategory){
//        this.productCategory=productCategory;
//        return this;
//    }
//    public ProductBuilder urlToImage(String urlToImage){
//        this.urlToImage=urlToImage;
//        return this;
//    }
//    public ProductBuilder categories(Set<Category> categories){
//        this.categories=categories;
//        return this;
//    }
//
//    @Override
//    public Product build() {
//        Product product=new Product();
//        product.setId(this.id);
//        product.setName(this.name);
//        product.setBrand(this.brand);
//        product.setPrice(this.price);
//        product.setProductCategory(this.productCategory);
//        product.setUrlToImage(this.urlToImage);
//        product.setCategories(this.categories);
//
//        return product;
//    }
//}
