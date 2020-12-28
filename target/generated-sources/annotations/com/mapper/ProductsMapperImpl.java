package com.mapper;

import com.DTO.CategoriesDTO;
import com.DTO.MediaDTO;
import com.DTO.ProductsDTO;
import com.entity.Categories;
import com.entity.Media;
import com.entity.Products;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-27T21:43:35+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ProductsMapperImpl implements ProductsMapper {

    @Override
    public ProductsDTO toDTO(Products products) {
        if ( products == null ) {
            return null;
        }

        ProductsDTO productsDTO = new ProductsDTO();

        productsDTO.setMediaDTO( mediaToMediaDTO( products.getMedia() ) );
        productsDTO.setCategoriesDTOList( categoriesListToCategoriesDTOList( products.getCategories() ) );
        productsDTO.setId( products.getId() );
        productsDTO.setName( products.getName() );
        productsDTO.setBrand( products.getBrand() );
        productsDTO.setPrice( products.getPrice() );

        return productsDTO;
    }

    @Override
    public Products toEntity(ProductsDTO productsDTO) {
        if ( productsDTO == null ) {
            return null;
        }

        Products products = new Products();

        products.setCategories( categoriesDTOListToCategoriesList( productsDTO.getCategoriesDTOList() ) );
        products.setMedia( mediaDTOToMedia( productsDTO.getMediaDTO() ) );
        products.setId( productsDTO.getId() );
        products.setName( productsDTO.getName() );
        products.setBrand( productsDTO.getBrand() );
        products.setPrice( productsDTO.getPrice() );

        return products;
    }

    @Override
    public List<ProductsDTO> toDTOList(List<Products> productsList) {
        if ( productsList == null ) {
            return null;
        }

        List<ProductsDTO> list = new ArrayList<ProductsDTO>( productsList.size() );
        for ( Products products : productsList ) {
            list.add( toDTO( products ) );
        }

        return list;
    }

    @Override
    public List<Products> toEntityList(List<ProductsDTO> productsDTOList) {
        if ( productsDTOList == null ) {
            return null;
        }

        List<Products> list = new ArrayList<Products>( productsDTOList.size() );
        for ( ProductsDTO productsDTO : productsDTOList ) {
            list.add( toEntity( productsDTO ) );
        }

        return list;
    }

    protected MediaDTO mediaToMediaDTO(Media media) {
        if ( media == null ) {
            return null;
        }

        MediaDTO mediaDTO = new MediaDTO();

        mediaDTO.setId( media.getId() );
        mediaDTO.setName( media.getName() );
        byte[] fileContent = media.getFileContent();
        if ( fileContent != null ) {
            mediaDTO.setFileContent( Arrays.copyOf( fileContent, fileContent.length ) );
        }

        return mediaDTO;
    }

    protected CategoriesDTO categoriesToCategoriesDTO(Categories categories) {
        if ( categories == null ) {
            return null;
        }

        CategoriesDTO categoriesDTO = new CategoriesDTO();

        categoriesDTO.setId( categories.getId() );
        categoriesDTO.setName( categories.getName() );
        categoriesDTO.setDescription( categories.getDescription() );

        return categoriesDTO;
    }

    protected List<CategoriesDTO> categoriesListToCategoriesDTOList(List<Categories> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoriesDTO> list1 = new ArrayList<CategoriesDTO>( list.size() );
        for ( Categories categories : list ) {
            list1.add( categoriesToCategoriesDTO( categories ) );
        }

        return list1;
    }

    protected Categories categoriesDTOToCategories(CategoriesDTO categoriesDTO) {
        if ( categoriesDTO == null ) {
            return null;
        }

        Categories categories = new Categories();

        categories.setId( categoriesDTO.getId() );
        categories.setName( categoriesDTO.getName() );
        categories.setDescription( categoriesDTO.getDescription() );

        return categories;
    }

    protected List<Categories> categoriesDTOListToCategoriesList(List<CategoriesDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Categories> list1 = new ArrayList<Categories>( list.size() );
        for ( CategoriesDTO categoriesDTO : list ) {
            list1.add( categoriesDTOToCategories( categoriesDTO ) );
        }

        return list1;
    }

    protected Media mediaDTOToMedia(MediaDTO mediaDTO) {
        if ( mediaDTO == null ) {
            return null;
        }

        Media media = new Media();

        media.setId( mediaDTO.getId() );
        media.setName( mediaDTO.getName() );
        byte[] fileContent = mediaDTO.getFileContent();
        if ( fileContent != null ) {
            media.setFileContent( Arrays.copyOf( fileContent, fileContent.length ) );
        }

        return media;
    }
}
