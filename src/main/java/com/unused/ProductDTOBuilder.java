//package com.builder.DTOBuilder;
//
//import com.unused.ProductDTO;
//import com.builder.Builder;
//import com.entity.Category;
//
//import java.util.Set;
//
//public class ProductDTOBuilder extends Builder {
//    private int id;
//    private String name;
//    private String brand;
//    private double price;
//    private String productCategory;
//    private String urlToImage;
//    private Set<Category> categories;
//
//    public  ProductDTOBuilder id(int id){
//        this.id=id;
//        return this;
//    }
//    public ProductDTOBuilder name(String name){
//        this.name=name;
//        return this;
//    }
//    public ProductDTOBuilder brand(String brand){
//        this.brand=brand;
//        return this;
//    }
//    public ProductDTOBuilder price(double price){
//        this.price=price;
//        return this;
//    }
//    public ProductDTOBuilder productCategory(String productCategory){
//        this.productCategory=productCategory;
//        return this;
//    }
//    public ProductDTOBuilder urlToImage(String urlToImage){
//        this.urlToImage=urlToImage;
//        return this;
//    }
//    public ProductDTOBuilder categories(Set<Category> categories){
//        this.categories=categories;
//        return this;
//    }
//
//    @Override
//    public ProductDTO build() {
//        ProductDTO productDTO=new ProductDTO();
//        productDTO.setId(this.id);
//        productDTO.setName(this.name);
//        productDTO.setBrand(this.brand);
//        productDTO.setPrice(this.price);
//        productDTO.setProductCategory(this.productCategory);
//        productDTO.setUrlToImage(this.urlToImage);
//        productDTO.setCategories(this.categories);
//
//        return productDTO;
//    }
//}

