package com.example.inventoryservice.service;

import java.util.List;

import com.example.inventoryservice.dto.InventoryDto;

public interface InventoryService {

    List<InventoryDto> getItems();

    InventoryDto getItemById(Integer itemId);

    InventoryDto addItem(InventoryDto inventoryDto);

    InventoryDto updateItem(Integer itemId, InventoryDto inventoryDto);

    String deleteItem(Integer itemId);
}
