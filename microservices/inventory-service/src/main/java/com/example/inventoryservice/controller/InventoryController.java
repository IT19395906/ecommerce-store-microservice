package com.example.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventoryservice.dto.InventoryDto;
import com.example.inventoryservice.service.InventoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping(value = "api/inventory/")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("getItems")
    public List<InventoryDto> getItems() {
        return inventoryService.getItems();
    }

    @GetMapping("item/{id}")
    public InventoryDto getItemById(@PathVariable Integer id) {
        return inventoryService.getItemById(id);
    }

    @GetMapping("item/{itemId}")
    public InventoryDto getItemByItemId(@PathVariable Integer itemId) {
        return inventoryService.getItemByItemId(itemId);
    }

    @PostMapping("addItem")
    public InventoryDto addItem(@RequestBody InventoryDto inventoryDto) {
        return inventoryService.addItem(inventoryDto);
    }

    @PutMapping("updateItem/{itemId}")
    public InventoryDto updateItem(@PathVariable Integer itemId, @RequestBody InventoryDto inventoryDto) {
        return inventoryService.updateItem(itemId, inventoryDto);
    }

    @DeleteMapping("deleteItem/{itemId}")
    public String deleteItem(@PathVariable Integer itemId) {
        return inventoryService.deleteItem(itemId);
    }

}
