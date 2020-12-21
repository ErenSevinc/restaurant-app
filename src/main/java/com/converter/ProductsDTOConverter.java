package com.converter;


import com.DTO.ProductsDTO;
import com.entity.Categories;
import com.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsDTOConverter {

    public static List<ProductsDTO> productsListConvertToProductsDTOList(List<Products> productsList) {
        List<ProductsDTO> productsDTOList = new ArrayList<>();
        for (Products products : productsList) {
            ProductsDTO productsDTO = new ProductsDTO();

            productsDTO.setId(products.getId());
            productsDTO.setName(products.getName());
            productsDTO.setBrand(products.getBrand());
            productsDTO.setPrice(products.getPrice());
            productsDTO.setCategoriesDTOList(CategoriesDTOConverter.categoriesListConvertToCategoriesDTOList(products.getCategories()));
            productsDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(products.getMedia()));

            productsDTOList.add(productsDTO);
        }
        return productsDTOList;
    }

    public static List<Products> productsDTOListConvertToProductsList(List<ProductsDTO> productsDTOList){
        List<Products> productsList =new ArrayList<>();
        for (ProductsDTO productsDTO : productsDTOList) {
            Products products = new Products();

            products.setId(productsDTO.getId());
            products.setName(productsDTO.getName());
            products.setBrand(productsDTO.getBrand());
            products.setPrice(productsDTO.getPrice());
            products.setCategories(CategoriesDTOConverter.categoriesDTOListConvertToCategoriesList(productsDTO.getCategoriesDTOList()));
            products.setMedia(MediaConverter.mediaDTOToConvertMedia(productsDTO.getMediaDTO()));

            productsList.add(products);
        }
        return productsList;
    }

    public static ProductsDTO productsConvertToProductsDTO(Products products){
        ProductsDTO productsDTO=new ProductsDTO();
        productsDTO.setId(products.getId());
        productsDTO.setName(products.getName());
        productsDTO.setBrand(products.getBrand());
        productsDTO.setPrice(products.getPrice());
        productsDTO.setCategoriesDTOList(CategoriesDTOConverter.categoriesListConvertToCategoriesDTOList(products.getCategories()));
        productsDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(products.getMedia()));

        return productsDTO;

    }

    public static  Products productsDTOConvertToProducts(ProductsDTO productsDTO){

        Products products=new Products();
        products.setId(productsDTO.getId());
        products.setName(productsDTO.getName());
        products.setBrand(productsDTO.getBrand());
        products.setPrice(productsDTO.getPrice());
        products.setCategories(CategoriesDTOConverter.categoriesDTOListConvertToCategoriesList(productsDTO.getCategoriesDTOList()));
        products.setMedia(MediaConverter.mediaDTOToConvertMedia(productsDTO.getMediaDTO()));

        return products;
    }

    public static Products addProducts(ProductsDTO productsDTO){
        Products products=new Products();

        products.setId(productsDTO.getId());
        products.setName(productsDTO.getName());
        products.setBrand(productsDTO.getBrand());
        products.setPrice(productsDTO.getPrice());
        products.setCategories(CategoriesDTOConverter.categoriesDTOListConvertToCategoriesList(productsDTO.getCategoriesDTOList()));
        products.setMedia(MediaConverter.mediaDTOToConvertMedia(productsDTO.getMediaDTO()));

        return products;

    }
    public  static Products updateProducts(ProductsDTO productsDTO,List<Categories> list){
        Products products=new Products();

        products.setId(productsDTO.getId());
        products.setName(productsDTO.getName());
        products.setBrand(productsDTO.getBrand());
        products.setPrice(productsDTO.getPrice());
        products.setMedia(MediaConverter.mediaDTOToConvertMedia(productsDTO.getMediaDTO()));
        products.setCategories(list);
        for(int i=0;i<list.size();i++){
            list.get(i).getProducts().add(products);
        }
        return products;
    }
    public static  List<ProductsDTO> getProductsByCategories(Categories categories){
        List<ProductsDTO> productsDTOList = new ArrayList<>();
        List<Products> productsList =new ArrayList<>();
        for (int i=0;i<categories.getProducts().size();i++){
            productsList.add(categories.getProducts().get(i));
        }
        for (Products products: productsList){
            ProductsDTO productsDTO=new ProductsDTO();
            productsDTO.setId(products.getId());
            productsDTO.setName(products.getName());
            productsDTO.setBrand(products.getBrand());
            productsDTO.setPrice(products.getPrice());
            productsDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(products.getMedia()));
            productsDTO.setCategoriesDTOList(CategoriesDTOConverter.categoriesListConvertToCategoriesDTOList(products.getCategories()));

            productsDTOList.add(productsDTO);
        }

        return productsDTOList;
    }
}
