package com.example.apirest.services;

import com.example.apirest.controllers.dto.CategoryResponse;
import com.example.apirest.persistence.entities.Category;
import com.example.apirest.persistence.repositories.CategoryJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryServiceImpl(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public CategoryResponse crearCategoria(String nombre, String descripcion) {

        Category category = new Category();
        category.setNombre(nombre);
        category.setDescripcion(descripcion);

        categoryJpaRepository.save(category);

        return mapToCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> obtenerCategorias() {

        List<Category> categories = categoryJpaRepository.findAll();

        /*
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (int i = 0; i < categories.size(); i ++) {
            categoryResponses.add(mapToCategoryResponse(categories.get(i)));
        }*/

        return categories.stream()
                /*.map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setId(category.getId());
                    response.setNombre(category.getNombre());
                    response.setDescripcion(category.getDescripcion());
                    return response;
                })*/
                .map(this::mapToCategoryResponse)
                .collect(Collectors.toList());
    }

    private CategoryResponse mapToCategoryResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setNombre(category.getNombre());
        response.setDescripcion(category.getDescripcion());
        return response;
    }
}
