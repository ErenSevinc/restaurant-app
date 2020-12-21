package com.service;

import com.DTO.OrderDTO;
import com.mapper.OrderMapper;
import com.unused.ProductDTO;
import com.converter.OrderConverter;
import com.unused.ProducrtConverter;
import com.unused.Product;
import com.unused.CategoryRepository;
import com.repository.OrderRepository;
import com.unused.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.entity.Order;

@Service
public class BackOfficeService {
    private List<Product> productList=new ArrayList<>();

    @Autowired
    ProductRepository repository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductDTO> getAllProduct(){
       List<Product> productList=repository.findAll();
       return ProducrtConverter.getAllProduct(productList);
    }

    public ProductDTO getSelectedProduct(int id){
        Product product=repository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
        return ProducrtConverter.getSelectedProduct(product);
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public List<ProductDTO> updateProduct(int id, ProductDTO productDTO){
//        Optional<Product> productList = repository.findAll().stream().filter(p->p.getId() ==id).findAny();
//        if (!productList.isPresent()){
//            System.out.println("Sonuç bulunamadı");
//            return null;
//        }
//        productList.get().setName(product.getName());
//        productList.get().setBrand(product.getBrand());
//        productList.get().setPrice(product.getPrice());
//        productList.get().setCategory(product.getCategory());
//        productList.get().setUrlToImage(product.getUrlToImage());
//        productList.get().setProductCategory(product.getProductCategory());
//
//        return repository.save(productList.get());

        productDTO.getCategories().add(categoryRepository.findById(id).get());
        repository.saveAndFlush(ProducrtConverter.updateProduct(productDTO));
        return getAllProduct();
    }

    public void deleteProduct(int id){
        Optional<Product> product =repository.findById(id);
        product.get().getCategories().stream().findAny().get().getProducts().remove(product.get());
        repository.deleteById(id);

    }

//    public List<String> getProductCategory(){
//       return repository.findAllCategory();
//    }
//
//    public List<Product> getProductByCategory(String category){
//
//        return repository.getCategoryProduct(category);
//    }

    public String addSales(List<OrderDTO> orderDTO){

//        orderRepository.saveAll(OrderConverter.addSales(orderDTO));
        orderRepository.saveAll(OrderMapper.INSTANCE.toEntity(orderDTO));
        return "Siparişiniz Alınmıştır";
    }

    public List<OrderDTO> listSales(){
//        List<?> list = orderRepository.findAll();
//        return (List<OrderDTO>) list;
//        List<Order> orderList=orderRepository.findAll();
//        return OrderConverter.listSales(orderList);
    return OrderMapper.INSTANCE.toDTO(orderRepository.findAll());
    }


}
