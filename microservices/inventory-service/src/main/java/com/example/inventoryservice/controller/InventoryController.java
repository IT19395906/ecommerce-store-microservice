package com.example.inventoryservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventoryservice.dto.InventoryDto;
import com.example.inventoryservice.service.InventoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping(value = "api/inventory/")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("getItems")
    public List<InventoryDto> getItems(@RequestParam String param) {
        inventoryService.getItems();
        return new ArrayList();
    }
    
}
