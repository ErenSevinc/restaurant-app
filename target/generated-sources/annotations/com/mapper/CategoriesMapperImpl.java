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
    date = "2020-12-25T02:02:34+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class CategoriesMapperImpl implements CategoriesMapper {

    @Override
    public CategoriesDTO toDTO(Categories categories) {
        if ( categories == null ) {
            return null;
        }

        CategoriesDTO categoriesDTO = new CategoriesDTO();

        categoriesDTO.setProductsDTOList( productsListToProductsDTOList( categories.getProducts() ) );
        categoriesDTO.setMediaDTO( mediaToMediaDTO( categories.getMedia() ) );
        categoriesDTO.setId( categories.getId() );
        categoriesDTO.setName( categories.getName() );
        categoriesDTO.setDescription( categories.getDescription() );

        return categoriesDTO;
    }

    @Override
    public Categories toEntity(CategoriesDTO categoriesDTO) {
        if ( categoriesDTO == null ) {
            return null;
        }

        Categories categories = new Categories();

        categories.setMedia( mediaDTOToMedia( categoriesDTO.getMediaDTO() ) );
        categories.setProducts( productsDTOListToProductsList( categoriesDTO.getProductsDTOList() ) );
        categories.setId( categoriesDTO.getId() );
        categories.setName( categoriesDTO.getName() );
        categories.setDescription( categoriesDTO.getDescription() );

        return categories;
    }

    @Override
    public List<CategoriesDTO> toDTOList(List<Categories> categoriesList) {
        if ( categoriesList == null ) {
            return null;
        }

        List<CategoriesDTO> list = new ArrayList<CategoriesDTO>( categoriesList.size() );
        for ( Categories categories : categoriesList ) {
            list.add( toDTO( categories ) );
        }

        return list;
    }

    @Override
    public List<Categories> toEntityList(List<CategoriesDTO> categoriesDTOList) {
        if ( categoriesDTOList == null ) {
            return null;
        }

        List<Categories> list = new ArrayList<Categories>( categoriesDTOList.size() );
        for ( CategoriesDTO categoriesDTO : categoriesDTOList ) {
            list.add( toEntity( categoriesDTO ) );
        }

        return list;
    }

    protected ProductsDTO productsToProductsDTO(Products products) {
        if ( products == null ) {
            return null;
        }

        ProductsDTO productsDTO = new ProductsDTO();

        productsDTO.setId( products.getId() );
        productsDTO.setName( products.getName() );
        productsDTO.setBrand( products.getBrand() );
        productsDTO.setPrice( products.getPrice() );

        return productsDTO;
    }

    protected List<ProductsDTO> productsListToProductsDTOList(List<Products> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductsDTO> list1 = new ArrayList<ProductsDTO>( list.size() );
        for ( Products products : list ) {
            list1.add( productsToProductsDTO( products ) );
        }

        return list1;
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

    protected Products productsDTOToProducts(ProductsDTO productsDTO) {
        if ( productsDTO == null ) {
            return null;
        }

        Products products = new Products();

        products.setId( productsDTO.getId() );
        products.setName( productsDTO.getName() );
        products.setBrand( productsDTO.getBrand() );
        products.setPrice( productsDTO.getPrice() );

        return products;
    }

    protected List<Products> productsDTOListToProductsList(List<ProductsDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Products> list1 = new ArrayList<Products>( list.size() );
        for ( ProductsDTO productsDTO : list ) {
            list1.add( productsDTOToProducts( productsDTO ) );
        }

        return list1;
    }
}
