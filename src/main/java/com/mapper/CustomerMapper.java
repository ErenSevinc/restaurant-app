package com.mapper;

import com.DTO.CustomerDTO;
import com.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE=null; //Mappers.getMapper(CustomerMapper.class);

    List<CustomerDTO> toDTOList(List<Customer> customerList);

    List<Customer> toEntityList(List<CustomerDTO> customerDTOList);

    @Mapping(source = "media",target = "mediaDTO")
    CustomerDTO toDTO(Customer customer);

    @Mapping(source = "mediaDTO",target = "media")
    Customer toEntity(CustomerDTO customerDTO);
}
