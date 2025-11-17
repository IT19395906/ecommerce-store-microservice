package com.example.inventoryservice.service;

import java.util.List;

import com.example.inventoryservice.dto.InventoryDto;

public interface InventoryService {

    List<InventoryDto> getItems();

    InventoryDto getItemById(Integer id);

    Integer getItemIdById(Integer id);

    InventoryDto getItemByItemId(Integer itemId);

    InventoryDto addItem(InventoryDto inventoryDto);

    InventoryDto updateItem(Integer id, InventoryDto inventoryDto);

    String deleteItem(Integer itemId);
}
