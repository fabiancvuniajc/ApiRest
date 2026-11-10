package com.example.apirest.controllers;

import com.example.apirest.controllers.dto.CategoryRequest;
import com.example.apirest.controllers.dto.CategoryResponse;
import com.example.apirest.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "categories", description = "Endpoint para administrar categorías")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> crearCategoria(
            @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(
                categoryService.crearCategoria
                        (categoryRequest.getNombre(), categoryRequest.getDescripcion()));
    }

    @GetMapping
    public ResponseEntity<?> obtenerCategorias() {
        return ResponseEntity.ok(categoryService.obtenerCategorias());
    }

}
