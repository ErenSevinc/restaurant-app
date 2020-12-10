package com.converter;

import com.DTO.WaiterDTO;
import com.entity.Waiter;

import java.util.ArrayList;
import java.util.List;

public class WaiterConverter {
    public static List<WaiterDTO> getAllWaiter(List<Waiter> list){
        List<WaiterDTO> waiterDTOList = new ArrayList<>();

        for(Waiter waiter: list){
            WaiterDTO waiterDTO=new WaiterDTO();
            waiterDTO.setId(waiter.getId());
            waiterDTO.setName(waiter.getName());
            waiterDTO.setPhoneNumber(waiter.getPhoneNumber());
            waiterDTO.setMail(waiter.getMail());
            waiterDTO.setAddress(waiter.getAddress());
            waiterDTO.setUrlToImage(waiter.getUrlToImage());
            waiterDTO.setSalary(waiter.getSalary());

            waiterDTOList.add(waiterDTO);
        }
        return waiterDTOList;
    }
    public static WaiterDTO getWaiterById(Waiter waiter){
        WaiterDTO waiterDTO=new WaiterDTO();
        waiterDTO.setId(waiter.getId());
        waiterDTO.setName(waiter.getName());
        waiterDTO.setPhoneNumber(waiter.getPhoneNumber());
        waiterDTO.setMail(waiter.getMail());
        waiterDTO.setAddress(waiter.getAddress());
        waiterDTO.setUrlToImage(waiter.getUrlToImage());
        waiterDTO.setSalary(waiter.getSalary());

        return waiterDTO;
    }
    public static Waiter addWaiter(WaiterDTO waiterDTO){
        Waiter waiter=new Waiter();
        waiter.setId(waiterDTO.getId());
        waiter.setName(waiterDTO.getName());
        waiter.setPhoneNumber(waiterDTO.getPhoneNumber());
        waiter.setMail(waiterDTO.getMail());
        waiter.setAddress(waiterDTO.getAddress());
        waiter.setUrlToImage(waiterDTO.getUrlToImage());
        waiter.setSalary(waiterDTO.getSalary());
        return waiter;
    }
    public static Waiter updateWaiter(WaiterDTO waiterDTO){
        Waiter waiter=new Waiter();
        waiter.setId(waiterDTO.getId());
        waiter.setName(waiterDTO.getName());
        waiter.setPhoneNumber(waiterDTO.getPhoneNumber());
        waiter.setMail(waiterDTO.getMail());
        waiter.setAddress(waiterDTO.getAddress());
        waiter.setUrlToImage(waiterDTO.getUrlToImage());
        waiter.setSalary(waiterDTO.getSalary());
        return waiter;
    }
}
