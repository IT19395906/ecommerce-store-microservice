package com.example.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    private int itemId;
    private int productId;
    private int quantity;
}
