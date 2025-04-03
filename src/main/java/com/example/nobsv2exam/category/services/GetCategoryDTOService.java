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
public class GetCategoryDTOService implements Command<UUID, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public GetCategoryDTOService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(UUID id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            return ResponseEntity.ok(new CategoryDTO(categoryOptional.get()));
        }

        throw new CategoryNotFoundException();
    }
}
