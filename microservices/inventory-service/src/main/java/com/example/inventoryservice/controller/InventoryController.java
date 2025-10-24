package com.example.inventoryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping(value = "api/inventory/")
public class InventoryController {

    @GetMapping("getItems")
    public String getItems(@RequestParam String param) {
        return new String();
    }
    
}
