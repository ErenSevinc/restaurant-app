package com.helper;

import com.DTO.*;
import com.entity.*;
import com.mapper.CategoriesMapper;
import com.mapper.MediaMapper;
import com.mapper.ProductsMapper;

public class EntityHelper {
    public static Customer updateCustomerHelper(Customer customer, CustomerDTO customerDTO){

        if (!customerDTO.getFirstName().equals(customer.getFirstName())){
            customer.setFirstName(customerDTO.getFirstName());
        }
        if(!customerDTO.getLastName().equals(customer.getLastName())){
            customer.setLastName(customerDTO.getLastName());
        }
        if (!customerDTO.getPhoneNumber().equals(customer.getPhoneNumber())){
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
        }
        if (!customerDTO.getAddress().equals(customer.getAddress())){
            customer.setAddress(customerDTO.getAddress());
        }
        if (!customerDTO.getMediaDTO().equals(MediaMapper.INSTANCE.toDTO(customer.getMedia()))){
            customer.setMedia(MediaMapper.INSTANCE.toEntity(customerDTO.getMediaDTO()));
        }
        return customer;
    }

    public static Waiter updateWaiterHelper(Waiter waiter, WaiterDTO waiterDTO){

        if(!waiterDTO.getName().equals(waiter.getName())){
            waiter.setName(waiterDTO.getName());
        }
        if(!waiterDTO.getAddress().equals(waiter.getAddress())){
            waiter.setAddress(waiterDTO.getAddress());
        }
        if (!waiterDTO.getPhoneNumber().equals(waiter.getPhoneNumber())){
            waiter.setPhoneNumber(waiterDTO.getPhoneNumber());
        }
        if (!waiterDTO.getMail().equals(waiter.getMail())){
            waiter.setMail(waiterDTO.getMail());
        }
        if (waiterDTO.getSalary()!= waiter.getSalary()){
            waiter.setSalary(waiterDTO.getSalary());
        }
        if (!waiterDTO.getMediaDTO().equals(MediaMapper.INSTANCE.toDTO(waiter.getMedia()))){
            waiter.setMedia(MediaMapper.INSTANCE.toEntity(waiterDTO.getMediaDTO()));
        }

        return waiter;
    }

    public static CategoryTable updateCategoryTableHelper(CategoryTable categoryTable, CategoryTableDTO categoryTableDTO){

        if (!categoryTableDTO.getName().equals(categoryTable.getName())){
            categoryTable.setName(categoryTableDTO.getName());
        }
        if (categoryTableDTO.getAmount() != categoryTableDTO.getAmount()){
            categoryTable.setAmount(categoryTableDTO.getAmount());
        }
        if(!categoryTableDTO.getMediaDTO().equals(categoryTable.getMedia())){
            categoryTable.setMedia(MediaMapper.INSTANCE.toEntity(categoryTableDTO.getMediaDTO()));
        }

        return categoryTable;
    }

    public static Categories updateCategoriesHelper(Categories categories, CategoriesDTO categoriesDTO){
        if(!categoriesDTO.getName().equals(categories.getName())){
            categories.setName(categoriesDTO.getName());
        }
        if (!categoriesDTO.getDescription().equals(categories.getDescription())){
            categories.setDescription(categoriesDTO.getDescription());
        }
        if(!categoriesDTO.getMediaDTO().equals(MediaMapper.INSTANCE.toDTO(categories.getMedia()))){
            categories.setMedia(MediaMapper.INSTANCE.toEntity(categoriesDTO.getMediaDTO()));
        }
        if (!categoriesDTO.getProductsDTOList().equals(ProductsMapper.mINSTANCE.toDTOList(categories.getProducts()))){
            categories.setProducts(ProductsMapper.mINSTANCE.toEntityList(categoriesDTO.getProductsDTOList()));
        }

        return categories;
    }

    public static Products updateProductsHelper(Products products, ProductsDTO productsDTO){
        if (!productsDTO.getName().equals(products.getName())){
            products.setName(productsDTO.getName());
        }
        if(!productsDTO.getBrand().equals(products.getBrand())){
            products.setBrand(productsDTO.getBrand());
        }
        if(productsDTO.getPrice() != products.getPrice()){
            products.setPrice(productsDTO.getPrice());
        }
        if(!productsDTO.getMediaDTO().equals(MediaMapper.INSTANCE.toDTO(products.getMedia()))){
            products.setMedia(MediaMapper.INSTANCE.toEntity(productsDTO.getMediaDTO()));
        }
        if (!productsDTO.getCategoriesDTOList().equals(CategoriesMapper.mINSTANCE.toDTOList(products.getCategories()))){
            products.setCategories(CategoriesMapper.mINSTANCE.toEntityList(productsDTO.getCategoriesDTOList()));
        }

        return products;
    }
}
