package com.service.start;

import com.DTO.CategoriesDTO;
import com.converter.CategoriesDTOConverter;
import com.entity.Categories;
import com.repository.CategoriesRepository;
import com.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductsRepository productsRepository;


    public List<CategoriesDTO> listCategories(){
        List<Categories> categoriesList=categoriesRepository.findAll();
        return CategoriesDTOConverter.listCategories(categoriesList);
    }

    public CategoriesDTO listCategoriesById(int id){
        Categories categories=categoriesRepository.findById(id).get();
        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
    }

    public CategoriesDTO addCategories(CategoriesDTO categoriesDTO){
        Categories categories=categoriesRepository.save(CategoriesDTOConverter.addCategories(categoriesDTO));
        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
    }

    public CategoriesDTO updateCategories(CategoriesDTO categoriesDTO){
        Categories categories=categoriesRepository.findById(categoriesDTO.getId()).get();
        categories.setProducts(null);
        categoriesRepository.saveAndFlush(CategoriesDTOConverter.updateCategories(categoriesDTO));
        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
    }

    public String deleteCategories(int id){
        Categories categories=categoriesRepository.findById(id).get();
        categories.setProducts(null);
        categoriesRepository.deleteById(categories.getId());
        return "Categories Deleted";
    }

}
