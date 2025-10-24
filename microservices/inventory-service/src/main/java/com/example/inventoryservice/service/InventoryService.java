package com.example.inventoryservice.service;

import java.util.List;

import com.example.inventoryservice.dto.InventoryDto;

public interface InventoryService {

    List<InventoryDto> getItems();
}
