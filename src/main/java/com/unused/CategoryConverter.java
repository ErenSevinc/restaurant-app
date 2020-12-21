package com.unused;

import com.converter.MediaConverter;

import java.util.*;

public class CategoryConverter {

    public static Category categoryDTOConvertToCategory(CategoryDTO categoryDTO){
        Category category=new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setUrlToImage(categoryDTO.getUrlToImage());

        return category;
    }
    public static CategoryDTO categoryConvertToCategoryDTO(Category category){
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setUrlToImage(category.getUrlToImage());

        return categoryDTO;
    }
    public static List<CategoryDTO> getCategory(List<Category> categoryList){

        List<CategoryDTO> categoryDTOList =new ArrayList<>();

        for(Category category:categoryList){
            CategoryDTO categoryDTO=new CategoryDTO();

            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            categoryDTO.setUrlToImage(category.getUrlToImage());
            categoryDTO.setProducts(category.getProducts());
            categoryDTO.setMedia(MediaConverter.mediaToConvertMediaDTO(category.getMedia()));
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    public static CategoryDTO getSelectedCategory(Category category) {

        CategoryDTO categoryDTO=new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setUrlToImage(category.getUrlToImage());
        categoryDTO.setProducts(category.getProducts());
        categoryDTO.setMedia(MediaConverter.mediaToConvertMediaDTO(category.getMedia()));
        return categoryDTO;
    }
    public static Category addCategory(CategoryDTO categoryDTO){

        Category category=new Category();

        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setUrlToImage(categoryDTO.getUrlToImage());
        category.setProducts(categoryDTO.getProducts());
        category.setMedia(MediaConverter.mediaDTOToConvertMedia(categoryDTO.getMediaDTO()));

        return category;
    }
    public static Category updateCategory(CategoryDTO categoryDTO){
        //        Optional<Category> categoryOptional = categoryRepository.findAll().stream().filter(p->p.getId() ==id).findAny();
//        if (!categoryOptional.isPresent()){
//            System.out.println("Sonuç bulunamadı");
//            return null;
//        }
//        categoryOptional.get().setName(category.getName());
//        categoryOptional.get().setDescription(category.getDescription());
//        categoryOptional.get().setUrlToImage(category.getUrlToImage());
//
//        return categoryRepository.save(categoryOptional.get());
        Category category=new Category();

        category.setProducts(categoryDTO.getProducts());
        category.setUrlToImage(categoryDTO.getUrlToImage());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setId(categoryDTO.getId());
        category.setMedia(MediaConverter.mediaDTOToConvertMedia(categoryDTO.getMediaDTO()));
        return category;
    }
    public static Product addProductByCategory(ProductDTO productDTO, Category category ){

//        productDTO.getCategories().add(category);
        List<Category> newSet =new ArrayList<>();
        newSet.add(category);

        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setProductCategory(productDTO.getProductCategory());
        product.setUrlToImage(productDTO.getUrlToImage());
        product.setCategories(newSet);
        category.getProducts().add(product);
        return product;
        // productDTO.setCategory(category.get());
        // category.get().getProducts().add(productDTO);
        // categoryRepository.save(category.get());
    }
    public static List<ProductDTO> getProductByCategory(Optional<Category> category){

        List<ProductDTO> productDTOSet=new ArrayList<>();

        for (Product prod: category.get().getProducts()){
            ProductDTO productDTO=new ProductDTO();
            productDTO.setId(prod.getId());
            productDTO.setCategories(prod.getCategories());
            productDTO.setName(prod.getName());
            productDTO.setBrand(prod.getBrand());
            productDTO.setPrice(prod.getPrice());
            productDTO.setUrlToImage(prod.getUrlToImage());
            productDTO.setProductCategory(prod.getProductCategory());
            productDTOSet.add(productDTO);
        }
        return productDTOSet;
        //return category.get().getProducts();
    }

}
