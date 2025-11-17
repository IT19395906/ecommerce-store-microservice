package com.example.productervice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
    private BigDecimal price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime addedDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String addedBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String updatedBy;
}
