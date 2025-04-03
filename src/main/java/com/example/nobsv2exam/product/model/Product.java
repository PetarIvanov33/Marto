package com.example.nobsv2exam.product.model;

import com.example.nobsv2exam.category.model.Category;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Size(min = 20, message = "Description must be atleast 20 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price is mandatory")
    @PositiveOrZero(message = "Price cannot be negative")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Manufacturer name is required")
    @Column(name = "manufacturer")
    private String manufacturer;

    @NotNull(message = "Cannot have no region")
    @Enumerated(EnumType.STRING)
    private Region region;

    @CreationTimestamp
    @Column(name = "created")
    private Instant createdOn;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Instant lastUpdatedOn;

    @NotNull(message = "Product must have a category")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;
}
