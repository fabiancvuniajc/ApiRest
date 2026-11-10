package com.example.apirest.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "videojuego")
public class VideoJuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuego")
    private Integer id;
    private String plataforma;
    private String titulo;
    private Double precio;
    private Integer stock;

    // Relación muchos a uno con la entidad Category N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Category category;
}
