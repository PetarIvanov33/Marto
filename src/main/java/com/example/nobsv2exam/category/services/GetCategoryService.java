package com.example.nobsv2exam.category.services;

import com.example.nobsv2exam.Command;
import com.example.nobsv2exam.category.CategoryRepository;
import com.example.nobsv2exam.category.model.Category;
import com.example.nobsv2exam.category.model.CategoryDTO;
import com.example.nobsv2exam.exceptions.CategoryNotFoundException;
import com.example.nobsv2exam.exceptions.ErrorMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetCategoryService implements Command<UUID, Category> {

    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Category> execute(UUID id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            return ResponseEntity.ok(categoryOptional.get());
        }

        throw new CategoryNotFoundException();
    }
}
