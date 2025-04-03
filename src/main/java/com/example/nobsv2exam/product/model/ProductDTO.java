package com.example.nobsv2exam.product.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    private String description;
    private Double price;
    private String manufacturer;
    private String categoryName;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.categoryName = product.getCategory().getName();
    }
}
