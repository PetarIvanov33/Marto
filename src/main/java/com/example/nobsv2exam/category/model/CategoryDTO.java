package com.example.nobsv2exam.category.model;

import com.example.nobsv2exam.product.model.Product;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CategoryDTO {
    private UUID id;
    private String name;
    private List<Product> products;

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.products = category.getProducts();
    }
}
