package com.service;

import com.DTO.CategoriesDTO;
import com.configuration.LocaleConfig;
import com.converter.CategoriesDTOConverter;
import com.entity.Categories;
import com.exception.SystemException;
import com.helper.EntityHelper;
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
import java.util.Locale;

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
    @Cacheable(value = "CategoriesCache", key = "'CATEGORIES_CACHE_BY_ID'.concat(#id)")
    public CategoriesDTO listCategoriesById(int id){
//        Categories categories=categoriesRepository.findById(id).get();
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
        return categoriesMapper.toDTO(categoriesRepository.findById(id).stream().filter(cat->cat.getId()==id).findAny()
                .orElseThrow(()->new SystemException("ID Bulunamadı")));
    }
    @CacheEvict(cacheNames = "CategoriesCache",allEntries = true)
    public CategoriesDTO addCategories(CategoriesDTO categoriesDTO){
//        Categories categories=categoriesRepository.save(CategoriesDTOConverter.addCategories(categoriesDTO));
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
        return categoriesMapper.toDTO(categoriesRepository.save(categoriesMapper.toEntity(categoriesDTO)));
    }
    @CacheEvict(cacheNames = "CategoriesCache",allEntries = true)
    public CategoriesDTO updateCategories(CategoriesDTO categoriesDTO){
//        Categories categories=categoriesRepository.findById(categoriesDTO.getId()).get();
//        categories.setProducts(null);
//        categoriesRepository.saveAndFlush(CategoriesDTOConverter.updateCategories(categoriesDTO));
//        return CategoriesDTOConverter.categoriesConvertToCategoriesDTO(categories);
//        return categoriesMapper.toDTO(categoriesRepository.saveAndFlush(categoriesMapper.toEntity(categoriesDTO)));
        Categories categories=categoriesRepository.findById(categoriesDTO.getId())
                .orElseThrow(()->new SystemException("Category not found"));

        EntityHelper.updateCategoriesHelper(categories,categoriesDTO);

        categoriesRepository.saveAndFlush(categories);

        return categoriesMapper.toDTO(categories);
    }
    @CacheEvict(cacheNames = "CategoriesCache",allEntries = true)
    public String deleteCategories(int id,String locale){
        Categories categories=categoriesRepository.findById(id).orElseThrow(()->
                new SystemException(LocaleConfig.messageSource().getMessage("system.exception.txt",null,new Locale(locale))));
        categories.setProducts(null);
        categoriesRepository.deleteById(categories.getId());
        return "Categories Deleted";
    }


}
