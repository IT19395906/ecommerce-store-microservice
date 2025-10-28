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

import jakarta.persistence.EntityNotFoundException;

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
        if(!item.isPresent()){
            throw new EntityNotFoundException("Item id " + itemId + " not found");
        }
        return modelMapper.map(item,InventoryDto.class);
    }

    @Override
    public InventoryDto addItem(InventoryDto inventoryDto) {
        Inventory savedItem = inventoryRepository.save(modelMapper.map(inventoryDto, Inventory.class));
        return modelMapper.map(savedItem,InventoryDto.class);
    }

    @Override
    public InventoryDto updateItem(Integer itemId, InventoryDto inventoryDto) {
        Optional<Inventory> item = inventoryRepository.findById(itemId);
        if(!item.isPresent()){
            throw new EntityNotFoundException("Item id " + itemId + " not found");
        }

        Inventory existing = item.get();

        modelMapper.map(inventoryDto,existing);
        Inventory updated = inventoryRepository.save(existing);
        return modelMapper.map(updated, InventoryDto.class);
    }

    @Override
    public String deleteItem(Integer itemId) {
        if(!inventoryRepository.existsById(itemId)){
            throw new EntityNotFoundException("Item id " + itemId + " not found");
        }
        inventoryRepository.deleteById(itemId);
        return "Successfully Deleted";
    }

}
