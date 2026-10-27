package com.example.apirest.controllers;

import com.example.apirest.controllers.dto.CrearProductRequest;
import com.example.apirest.controllers.dto.ProductResponse;
import com.example.apirest.persistence.entities.Product;
import com.example.apirest.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "products", description = "Endpoint para administrar productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Saludo inicial", description = "probando mi primer api")
    @ApiResponse(responseCode = "200", description = "Respuesta exitosa")
    public ResponseEntity<List<Product>> getProduct() {

        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Obtiene un producto por su ID")
    @ApiResponse(responseCode = "200", description = "Producto encontrado exitosamente")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        ProductResponse product = productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
    public ResponseEntity<ProductResponse> createProduct(CrearProductRequest product) {
        return ResponseEntity.status(201).body(productService.save(product));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto existente")
    @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id,
                                                         @RequestBody CrearProductRequest product)
    {
        return ResponseEntity.status(201).body(productService.update(product, id));
    }
}
