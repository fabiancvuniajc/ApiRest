package com.example.apirest.persistence.repositories;

import com.example.apirest.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    List<Product> findByCategoriaAndNameAndCodigo
            (String categoria, String name, String codigo);

    @Query("SELECT p FROM Product p WHERE " +
            "p.categoria = :categoria AND " +
            "p.name = :name AND " +
            "p.stock > :stockMinimo AND p.stock < :StockMaximo")
    List<Product> findProductsPorQuery(String categoria, String name,
                                       Integer stockMinimo, Integer StockMaximo);
}
