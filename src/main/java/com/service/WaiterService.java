package com.service;

import com.DTO.WaiterDTO;
import com.converter.WaiterConverter;
import com.entity.Waiter;
import com.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {

    @Autowired
    private WaiterRepository waiterRepository;

    public List<WaiterDTO> getAllWaiter(){
        List<Waiter> waiterList =waiterRepository.findAll();
        return WaiterConverter.getAllWaiter(waiterList);
    }
    public WaiterDTO getWaiterById(int id){
        Waiter waiter=waiterRepository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
        return WaiterConverter.getWaiterById(waiter);
    }
    public String addWaiter(WaiterDTO waiterDTO){
        waiterRepository.save(WaiterConverter.addWaiter(waiterDTO));
        return "Waiter Added";
    }
    public WaiterDTO updateWaiter(WaiterDTO waiterDTO){
        waiterRepository.saveAndFlush(WaiterConverter.updateWaiter(waiterDTO));
        return waiterDTO;
    }
    public List<WaiterDTO> deleteWaiter(int id){
        waiterRepository.deleteById(id);
        return getAllWaiter();
    }
}
