package com.example.inventoryservice.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventoryservice.dto.InventoryDto;
import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.repo.InventoryRepository;
import com.example.inventoryservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<InventoryDto> getItems() {
        List<Inventory> itemList = inventoryRepository.findAll();
        return itemList.stream().map(item-> modelMapper.map(item, InventoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public InventoryDto getItemById(Integer itemId) {
        Optional<Inventory> item = inventoryRepository.findById(itemId);
        return modelMapper.map(item,InventoryDto.class);
    }

    @Override
    public InventoryDto addItem(InventoryDto inventoryDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    @Override
    public InventoryDto updateItem(Integer itemId, InventoryDto inventoryDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
    }

    @Override
    public String deleteItem(Integer itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
    }

}
