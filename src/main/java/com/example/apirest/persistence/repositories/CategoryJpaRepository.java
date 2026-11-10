package com.example.apirest.persistence.repositories;

import com.example.apirest.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByNombre(String nombre);
}
