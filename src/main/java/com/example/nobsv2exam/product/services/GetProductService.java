package com.example.nobsv2exam.product.services;

import com.example.nobsv2exam.Query;
import com.example.nobsv2exam.exceptions.ProductNotFoundException;
import com.example.nobsv2exam.product.ProductRepository;
import com.example.nobsv2exam.product.model.Product;
import com.example.nobsv2exam.product.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class GetProductService implements Query<UUID, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> execute(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        throw new ProductNotFoundException();
    }
}

// ac8fb2db-4f6a-4f02-8f1f-4986bb06a158