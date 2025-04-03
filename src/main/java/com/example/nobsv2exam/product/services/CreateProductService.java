package com.example.nobsv2exam.product.services;

import com.example.nobsv2exam.Command;
import com.example.nobsv2exam.category.model.Category;
import com.example.nobsv2exam.category.model.CategoryDTO;
import com.example.nobsv2exam.category.services.GetCategoryService;
import com.example.nobsv2exam.product.ProductRepository;
import com.example.nobsv2exam.product.model.Product;
import com.example.nobsv2exam.product.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;
    private final GetCategoryService getCategoryService;

    public CreateProductService(ProductRepository productRepository, GetCategoryService getCategoryService) {
        this.productRepository = productRepository;
        this.getCategoryService = getCategoryService;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        log.info("Executing {} for product with id: {}", getClass(), product.getId());
        Category category = getCategoryService.execute(product.getCategory().getId()).getBody();

        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }
}
