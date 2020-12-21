package com.service;

import com.DTO.WaiterDTO;
import com.converter.WaiterConverter;
import com.entity.Waiter;
import com.mapper.WaiterMapper;
import com.repository.MediaRepository;
import com.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {
//return OrderMapper.INSTANCE.toDTO(orderRepository.findAll());
    @Autowired
    private WaiterRepository waiterRepository;
    @Autowired
    private MediaRepository mediaRepository;

    public List<WaiterDTO> getAllWaiter(){
//        List<Waiter> waiterList =waiterRepository.findAll();
//        return WaiterConverter.getAllWaiter(waiterList);
        return WaiterMapper.INSTANCE.toDTOList(waiterRepository.findAll());
    }
    public WaiterDTO getWaiterById(int id){
//        Waiter waiter=waiterRepository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
//        return WaiterConverter.getWaiterById(waiter);
        return WaiterMapper.INSTANCE.toDTO(waiterRepository.findById(id).get());
    }
    public String addWaiter(WaiterDTO waiterDTO){
//        waiterRepository.save(WaiterConverter.addWaiter(waiterDTO));
        waiterRepository.save(WaiterMapper.INSTANCE.toEntity(waiterDTO));
        return "Waiter Added";
    }
    public WaiterDTO updateWaiter(WaiterDTO waiterDTO){
       return WaiterMapper.INSTANCE.toDTO(waiterRepository.saveAndFlush(WaiterMapper.INSTANCE.toEntity(waiterDTO)));
//        return waiterDTO;
    }
    public List<WaiterDTO> deleteWaiter(int id){
        waiterRepository.deleteById(id);
        return getAllWaiter();
    }
}
