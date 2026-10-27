package com.example.apirest.services;

import com.example.apirest.controllers.dto.CrearProductRequest;
import com.example.apirest.controllers.dto.ProductResponse;
import com.example.apirest.persistence.entities.Product;
import com.example.apirest.persistence.repositories.ProductJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJpaRepository;

    public ProductServiceImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public ProductResponse findById(int id) {
        return productJpaRepository.findById(id)
                .map(product -> new ProductResponse(
                product.getCategoria(),
                product.getName(),
                product.getPrecio(),
                product.getStock(),
                product.getCodigo()
        )).orElse(null);
    }

    @Override
    public List<Product> findByCategoriaAndNameAndCodigo(String categoria, String name, String codigo) {
        return productJpaRepository.findByCategoriaAndNameAndCodigo(categoria, name, codigo);
    }

    @Override
    public List<Product> findProductsPorQuery(String categoria, String name, Integer stockMinimo, Integer StockMaximo) {
        return productJpaRepository.findProductsPorQuery(categoria, name, stockMinimo, StockMaximo);
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll();
    }

    @Override
    public ProductResponse save(CrearProductRequest product) {

        if (productJpaRepository.findByName(product.getName()).isPresent()) {
            throw new RuntimeException("Product with name " + product.getName() + " already exists");
        }

        Product newProduct = new Product();
        newProduct.setActivo(product.isActivo());
        newProduct.setCategoria(product.getCategoria());
        newProduct.setName(product.getName());
        newProduct.setPrecio(product.getPrecio());
        newProduct.setStock(product.getStock());
        newProduct.setCodigo(product.getCodigo());

        Product savedProduct = productJpaRepository.save(newProduct);
        return new ProductResponse(
                savedProduct.getCategoria(),
                savedProduct.getName(),
                savedProduct.getPrecio(),
                savedProduct.getStock(),
                savedProduct.getCodigo()
        );
    }

    @Override
    public ProductResponse update(CrearProductRequest product, Integer id) {
        Product existingProduct = productJpaRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setActivo(product.isActivo());
            existingProduct.setCategoria(product.getCategoria());
            existingProduct.setName(product.getName());
            existingProduct.setPrecio(product.getPrecio());
            existingProduct.setStock(product.getStock());
            existingProduct.setCodigo(product.getCodigo());
            productJpaRepository.save(existingProduct);

            return new ProductResponse(
                    existingProduct.getCategoria(),
                    existingProduct.getName(),
                    existingProduct.getPrecio(),
                    existingProduct.getStock(),
                    existingProduct.getCodigo()
            );
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        productJpaRepository.deleteById(id);
    }
}
