package com.example.nobsv2exam.product.services;

import com.example.nobsv2exam.Command;
import com.example.nobsv2exam.exceptions.ProductNotFoundException;
import com.example.nobsv2exam.product.ProductRepository;
import com.example.nobsv2exam.product.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class DeleteProductService implements Command<UUID, Void> {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(UUID id) {
        log.info("Executing {} for product with id: {}", DeleteProductService.class, id);
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            log.info("Product is present, deleting the product");
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new ProductNotFoundException();
    }
}
