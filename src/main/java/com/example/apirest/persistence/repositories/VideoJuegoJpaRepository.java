package com.example.apirest.persistence.repositories;

import com.example.apirest.persistence.entities.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoJuegoJpaRepository extends JpaRepository<VideoJuego, Integer> {

    List<VideoJuego> findByCategory_Name(String categoryName);

    @Query("SELECT v FROM VideoJuego v WHERE " +
            "v.category.name = :nombreCategoria")
    List<VideoJuego> buscarPorNombreCagegorio(String nombreCategoria);
}
