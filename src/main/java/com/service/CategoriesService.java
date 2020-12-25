package com.service;

import com.DTO.CategoriesDTO;
import com.converter.CategoriesDTOConverter;
import com.entity.Categories;
import com.mapper.CategoriesMapper;
import com.mapper.ProductsMapper;
import com.repository.CategoriesRepository;
import com.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Autowired
    private ProductsMapper productsMapper;

    @Cacheable(value = "CategoriesCache", key = "'CATEGORIES_CACHE'")
    public List<CategoriesDTO> listCategories() {
//        List<Categories> categoriesList=categoriesRepository.findAll();
//        return CategoriesDTOConverter.listCategories(categoriesList);
        return categoriesMapper.toDTOList(categoriesRepository.findAll());
    }
    @Cacheable(value = "CategoriesCache", key = "'CATEGORIES_CACHE_BY_ID'.concat(#id)",condition = "#id>=2")
    public CategoriesDTO listCategoriesById(int id){
//        Categories categories=categoriesRepository.findById(id).get();
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
        return categoriesMapper.toDTO(categoriesRepository.findById(id).get());
    }
    @CachePut(cacheNames = "CategoriesCache")
    public CategoriesDTO addCategories(CategoriesDTO categoriesDTO){
//        Categories categories=categoriesRepository.save(CategoriesDTOConverter.addCategories(categoriesDTO));
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
        return categoriesMapper.toDTO(categoriesRepository.save(categoriesMapper.toEntity(categoriesDTO)));
    }
    @CachePut(cacheNames = "CategoriesCache")
    public CategoriesDTO updateCategories(CategoriesDTO categoriesDTO){
//        Categories categories=categoriesRepository.findById(categoriesDTO.getId()).get();
//        categories.setProducts(null);
//        categoriesRepository.saveAndFlush(CategoriesDTOConverter.updateCategories(categoriesDTO));
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
        return categoriesMapper.toDTO(categoriesRepository.saveAndFlush(categoriesMapper.toEntity(categoriesDTO)));
    }
    @CacheEvict(cacheNames = "CategoriesCache")
    public String deleteCategories(int id){
        Categories categories=categoriesRepository.findById(id).get();
        categories.setProducts(null);
        categoriesRepository.deleteById(categories.getId());
        return "Categories Deleted";
    }


}
