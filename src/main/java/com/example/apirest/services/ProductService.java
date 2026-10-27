package com.example.apirest.services;

import com.example.apirest.controllers.dto.CrearProductRequest;
import com.example.apirest.controllers.dto.ProductResponse;
import com.example.apirest.persistence.entities.Product;

import java.util.List;

public interface ProductService {

    ProductResponse findById(int id);

    List<Product> findByCategoriaAndNameAndCodigo(String categoria, String name, String codigo);

    List<Product> findProductsPorQuery(String categoria, String name, Integer stockMinimo, Integer StockMaximo);

    List<Product> findAll();

    ProductResponse save(CrearProductRequest product);

    ProductResponse update(CrearProductRequest product, Integer id);

    void delete(Integer id);

}
