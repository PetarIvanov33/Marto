package com.example.nobsv2exam.category.services;

import com.example.nobsv2exam.Command;
import com.example.nobsv2exam.category.CategoryRepository;
import com.example.nobsv2exam.category.model.Category;
import com.example.nobsv2exam.category.model.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements Command<Category, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public CreateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryDTO(category));
    }
}
