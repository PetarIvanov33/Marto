package com.example.nobsv2exam.category;

import com.example.nobsv2exam.category.model.Category;
import com.example.nobsv2exam.category.model.CategoryDTO;
import com.example.nobsv2exam.category.services.CreateCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CreateCategoryService createCategoryService;

    public CategoryController(CreateCategoryService createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody Category category){
        return createCategoryService.execute(category);
    }
}
