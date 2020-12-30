package com.service;

import com.DTO.WaiterDTO;
import com.converter.WaiterConverter;
import com.entity.Waiter;
import com.exception.BusinessRuleException;
import com.exception.SystemException;
import com.helper.EntityHelper;
import com.mapper.WaiterMapper;
import com.repository.MediaRepository;
import com.repository.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Waiter waiter=waiterRepository.findById(id).get();
        if (waiter==null){
            throw new BusinessRuleException("waiter bulunamadı");
        }
//        return WaiterConverter.getWaiterById(waiter);
        return WaiterMapper.INSTANCE.toDTO(waiter);
    }
    @Transactional
    public String addWaiter(WaiterDTO waiterDTO){
        waiterRepository.save(WaiterMapper.INSTANCE.toEntity(waiterDTO));
        return "Waiter Added";
    }
    @Transactional
    public WaiterDTO updateWaiter(WaiterDTO waiterDTO){
        Waiter waiter=waiterRepository.findById(waiterDTO.getId()).get();
        if(waiter==null){
            throw new BusinessRuleException("waiter bulunamadı");
        }

        EntityHelper.updateWaiterHelper(waiter,waiterDTO);

        waiterRepository.saveAndFlush(waiter);

       return WaiterMapper.INSTANCE.toDTO(waiter);
    }
    public List<WaiterDTO> deleteWaiter(int id){
        Waiter waiter=waiterRepository.findById(id)
                .orElseThrow(()->new BusinessRuleException("ID Bulunamadı"));

        waiterRepository.deleteById(waiter.getId());
        return getAllWaiter();
    }
}
