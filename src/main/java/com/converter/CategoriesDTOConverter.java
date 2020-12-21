package com.converter;


import com.DTO.CategoriesDTO;

import com.entity.Categories;


import java.util.ArrayList;
import java.util.List;


public class CategoriesDTOConverter {
    public static CategoriesDTO categoriesConvertToCategoriesDTO(Categories categories){

        CategoriesDTO categoriesDTO=new CategoriesDTO();

        categoriesDTO.setId(categories.getId());
        categoriesDTO.setName(categories.getName());
        categoriesDTO.setDescription(categories.getDescription());
        categoriesDTO.setProductsDTOList(ProductsDTOConverter.productsListConvertToProductsDTOList(categories.getProducts()));
        categoriesDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(categories.getMedia()));

        return categoriesDTO;
    }
    public static Categories categoriesDTOConvertToCategories(CategoriesDTO categoriesDTO){

        Categories categories=new Categories();

        categories.setId(categoriesDTO.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        categories.setProducts(ProductsDTOConverter.productsDTOListConvertToProductsList(categoriesDTO.getProductsDTOList()));
        categories.setMedia(MediaConverter.mediaDTOToConvertMedia(categoriesDTO.getMediaDTO()));

        return categories;
    }

    public static List<CategoriesDTO> categoriesListConvertToCategoriesDTOList(List<Categories> categoriesList) {
        List<CategoriesDTO> categoriesDTOList = new ArrayList<>();
        for (Categories categories : categoriesList) {
            CategoriesDTO categoriesDTO = new CategoriesDTO();

            categoriesDTO.setId(categories.getId());
            categoriesDTO.setName(categories.getName());
            categoriesDTO.setDescription(categories.getDescription());
            categoriesDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(categories.getMedia()));

            categoriesDTOList.add(categoriesDTO);
        }

        return categoriesDTOList;
    }
    public static List<Categories> categoriesDTOListConvertToCategoriesList(List<CategoriesDTO> categoriesDTOList) {
        List<Categories> categoriesList = new ArrayList<>();
        for (CategoriesDTO categoriesDTO : categoriesDTOList) {
            Categories categories = new Categories();

            categories.setId(categoriesDTO.getId());
            categories.setName(categoriesDTO.getName());
            categories.setDescription(categoriesDTO.getDescription());
            categories.setMedia(MediaConverter.mediaDTOToConvertMedia(categoriesDTO.getMediaDTO()));

            categoriesList.add(categories);
        }

        return categoriesList;
    }

    public static List<CategoriesDTO> listCategories(List<Categories> categoriesList) {
        List<CategoriesDTO> categoriesDTOList = new ArrayList<>();
        for (Categories categories : categoriesList) {
            CategoriesDTO categoriesDTO = new CategoriesDTO();

            categoriesDTO.setId(categories.getId());
            categoriesDTO.setName(categories.getName());
            categoriesDTO.setDescription(categoriesDTO.getDescription());
            categoriesDTO.setMediaDTO(MediaConverter.mediaToConvertMediaDTO(categories.getMedia()));

            categoriesDTOList.add(categoriesDTO);
        }

        return categoriesDTOList;
    }

    public static Categories addCategories(CategoriesDTO categoriesDTO) {
        Categories categories = new Categories();

        categories.setId(categoriesDTO.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        categories.setMedia(MediaConverter.mediaDTOToConvertMedia(categoriesDTO.getMediaDTO()));

        return categories;
    }

    public static Categories updateCategories(CategoriesDTO categoriesDTO){
        Categories categories = new Categories();

        categories.setId(categoriesDTO.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        categories.setMedia(MediaConverter.mediaDTOToConvertMedia(categoriesDTO.getMediaDTO()));

        return categories;

    }
}
