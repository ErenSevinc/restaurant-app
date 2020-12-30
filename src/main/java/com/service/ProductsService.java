package com.service;

import com.DTO.ProductsDTO;
import com.DTO.ProductsSliceWrapperDTO;
import com.DTO.ProductsWrapperList;
import com.converter.ProductsDTOConverter;
import com.entity.Categories;
import com.entity.Products;
import com.exception.BusinessRuleException;
import com.exception.SystemException;
import com.helper.EntityHelper;
import com.mapper.CategoriesMapper;
import com.mapper.ProductsMapper;
import com.repository.CategoriesRepository;
import com.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private CategoriesMapper categoriesMapper;

    public List<ProductsDTO> listProducts(){
//        List<Products> productsList = productsRepository.findAll();
//        return ProductsDTOConverter.productsListConvertToProductsDTOList(productsList);
        return productsMapper.toDTOList(productsRepository.findAll());
    }

    public ProductsDTO listProductsById(int id){
//        Products products = productsRepository.findById(id).get();
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);

        return productsMapper.toDTO(productsRepository.findById(id).orElseThrow(()->new BusinessRuleException("Product not found")));
    }
    public ProductsWrapperList listProductsMore(Pageable pageable){
        if(pageable.equals(null)){
            throw new BusinessRuleException("pageable is null");
        }
        Page<Products> productsPage= productsRepository.findAll(pageable);
        List<Products> productsList=productsPage.getContent();
        List<ProductsDTO> productsDTOList=productsMapper.toDTOList(productsList);

        for(int i=0;i<productsList.size();i++){
            productsDTOList.get(i).setCategoriesDTOList(categoriesMapper.toDTOList(productsList.get(i).getCategories()));
        }
        ProductsWrapperList productsWrapperList=new ProductsWrapperList();
        productsWrapperList.setProductsDTOList(productsDTOList);
        productsWrapperList.setTotalElements((int) productsPage.getTotalElements());

        return productsWrapperList;
    }
    public ProductsSliceWrapperDTO loadMoreProducts(int id,int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        if(pageable.equals(null)){
            throw new BusinessRuleException("pageable is null");
        }

        Slice<Products> productsSlice=productsRepository.findProductsByCategoriesId(id,pageable);
        List<Products> productsList=productsSlice.toList();
        List<ProductsDTO> productsDTOList=productsMapper.toDTOList(productsList);

        ProductsSliceWrapperDTO sliceWrapperDTO=new ProductsSliceWrapperDTO();
        sliceWrapperDTO.setProductsDTOList(productsDTOList);
        sliceWrapperDTO.setHasNext(productsSlice.hasNext());
        return sliceWrapperDTO;

    }

    @Transactional
    public ProductsDTO addProducts(ProductsDTO productsDTO){
        Products products=productsMapper.toEntity(productsDTO);

        for (int i=0;i<productsDTO.getCategoriesDTOList().size();i++){
            Categories categories=categoriesRepository.findById(productsDTO.getCategoriesDTOList().get(i).getId()).get();
            categories.getProducts().add(products);
        }
        return productsMapper.toDTO(productsRepository.save(products));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
//        Products products=productsRepository.save(ProductsDTOConverter.productsDTOConvertToProducts(productsDTO));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
    }
    @Transactional
    public ProductsDTO updateProducts(ProductsDTO productsDTO){
        Products products=productsRepository.findById(productsDTO.getId()).get();

//        EntityHelper.updateProductsHelper(products,productsDTO);
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
        products.setCategories(categoriesList1);
        for(int i=0;i<categoriesList1.size();i++){
            categoriesList1.get(i).getProducts().add(products);
        }

        productsRepository.saveAndFlush(products);
        return productsMapper.toDTO(products);


//-----------------------------------------
//        productsRepository.saveAndFlush(ProductsDTOConverter.updateProducts(productsDTO,categoriesList1));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
//        Products products=productsMapper.toEntity(productsDTO);
//        List<Categories> categoriesList=products.getCategories();
//        for (int i=0;i<categoriesList.size();i++){
//            categoriesList.get(i).getProducts().remove(products);
//            categoriesRepository.save(categoriesList.get(i));
//        }
//        List<Categories> categoriesList1 =new ArrayList<>();
//        for (int i=0;i<productsDTO.getCategoriesDTOList().size();i++){
//            Categories categories=categoriesRepository.findById(productsDTO.getCategoriesDTOList().get(i).getId()).get();
//            categoriesList1.add(categories);
//        }

//        productsRepository.saveAndFlush(products);
//        return productsMapper.toDTO(products);



//        Products products=productsRepository.findById(productsDTO.getId()).get();
//        products.setCategories(null);
//        productsRepository.saveAndFlush(ProductsDTOConverter.productsDTOConvertToProducts(productsDTO));
//        return ProductsDTOConverter.productsConvertToProductsDTO(products);
    }

    public String deleteProducts(int id){
        Products products=productsRepository.findById(id).orElseThrow(()->new BusinessRuleException("Product not found"));
        for (int i=0;i<products.getCategories().size();i++){
            Optional<Categories> categories=categoriesRepository.findById(products.getCategories().get(i).getId());
            categories.get().getProducts().remove(products);
        }
        productsRepository.deleteById(id);

        return "Products Deleted";
    }

    public List<ProductsDTO> getProductsByCategories(int id){
        Categories categories = categoriesRepository.findById(id).orElseThrow(()->new BusinessRuleException("ID not found"));
        return ProductsDTOConverter.getProductsByCategories(categories);
    }

}
