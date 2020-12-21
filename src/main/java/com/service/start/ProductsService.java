package com.service.start;

import com.DTO.ProductsDTO;
import com.converter.ProductsDTOConverter;
import com.entity.Categories;
import com.entity.Products;
import com.repository.CategoriesRepository;
import com.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<ProductsDTO> listProducts(){
        List<Products> productsList = productsRepository.findAll();
        return ProductsDTOConverter.productsListConvertToProductsDTOList(productsList);
    }

    public ProductsDTO listProductsById(int id){
        Products products = productsRepository.findById(id).get();
        return ProductsDTOConverter.productsConvertToProductsDTO(products);

    }

    public ProductsDTO addProducts(ProductsDTO productsDTO){
        Products products=ProductsDTOConverter.productsDTOConvertToProducts(productsDTO);

        for (int i=0;i<productsDTO.getCategoriesDTOList().size();i++){
            Categories categories=categoriesRepository.findById(productsDTO.getCategoriesDTOList().get(i).getId()).get();
            categories.getProducts().add(products);
        }
        productsRepository.save(products);

        return ProductsDTOConverter.productsConvertToProductsDTO(products);
//        Products products=productsRepository.save(ProductsDTOConverter.productsDTOConvertToProducts(productsDTO));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
    }

    public ProductsDTO updateProducts(ProductsDTO productsDTO){
        Products products=productsRepository.findById(productsDTO.getId()).get();
        List<Categories> categoriesList=products.getCategories();
        for (int i=0;i<categoriesList.size();i++){
            categoriesList.get(i).getProducts().remove(products);
            categoriesRepository.save(categoriesList.get(i));
        }
        List<Categories> categoriesList1 =new ArrayList<>();
        for (int i=0;i<productsDTO.getCategoriesDTOList().size();i++){
            Categories categories=categoriesRepository.findById(productsDTO.getCategoriesDTOList().get(i).getId()).get();
            categoriesList1.add(categories);
        }
        productsRepository.saveAndFlush(ProductsDTOConverter.updateProducts(productsDTO,categoriesList1));
        return ProductsDTOConverter.productsConvertToProductsDTO(products);


//        Products products=productsRepository.findById(productsDTO.getId()).get();
//        products.setCategories(null);
//        productsRepository.saveAndFlush(ProductsDTOConverter.productsDTOConvertToProducts(productsDTO));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
    }

    public String deleteProducts(int id){
        Products products=productsRepository.findById(id).get();
        for (int i=0;i<products.getCategories().size();i++){
            Optional<Categories> categories=categoriesRepository.findById(products.getCategories().get(i).getId());
            categories.get().getProducts().remove(products);
        }
        productsRepository.deleteById(id);

        return "Products Deleted";
    }

    public List<ProductsDTO> getProductsByCategories(int id){
        Categories categories = categoriesRepository.findById(id).get();
        return ProductsDTOConverter.getProductsByCategories(categories);
    }




}
