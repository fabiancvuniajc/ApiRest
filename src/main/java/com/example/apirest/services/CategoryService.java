package com.example.apirest.services;

import com.example.apirest.controllers.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse crearCategoria(String nombre, String descripcion);

    List<CategoryResponse> obtenerCategorias();
}
