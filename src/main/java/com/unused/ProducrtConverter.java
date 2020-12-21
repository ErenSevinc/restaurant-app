package com.unused;

import java.util.ArrayList;
import java.util.List;

public class ProducrtConverter {

    public static Product productConvertToProductDTO(ProductDTO productDTO){
        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setProductCategory(productDTO.getProductCategory());
        product.setUrlToImage(productDTO.getUrlToImage());

        return product;
    }
    public static ProductDTO productDTOConvertToProduct(Product product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductCategory(product.getProductCategory());
        productDTO.setUrlToImage(product.getUrlToImage());

        return productDTO;
    }

    public static List<ProductDTO> getAllProduct(List<Product> productList) {

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product prod : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(prod.getId());
            productDTO.setName(prod.getName());
            productDTO.setBrand(prod.getBrand());
            productDTO.setPrice(prod.getPrice());
            productDTO.setProductCategory(prod.getProductCategory());
            productDTO.setUrlToImage(prod.getUrlToImage());
            productDTO.setCategories(prod.getCategories());
            productDTOList.add(productDTO);
        }
        return productDTOList;
        //return repository.findAll();
    }

    public static ProductDTO getSelectedProduct(Product product) {

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setProductCategory(product.getProductCategory());
        productDTO.setPrice(product.getPrice());
        productDTO.setUrlToImage(product.getUrlToImage());
        productDTO.setCategories(product.getCategories());

        return productDTO;
    }

    public static Product updateProduct(ProductDTO productDTO) {

        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setProductCategory(productDTO.getProductCategory());
        product.setPrice(productDTO.getPrice());
        product.setUrlToImage(productDTO.getUrlToImage());
        product.setCategories(productDTO.getCategories());

        return product;
    }
}
