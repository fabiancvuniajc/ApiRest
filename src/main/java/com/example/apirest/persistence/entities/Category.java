package com.example.apirest.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;

    private String descripcion;

    @Column(name = "nombre_categoria")
    private String nombre;

    // Relación uno a muchos con la entidad VideoJuego 1:N
    @OneToMany(mappedBy = "category")
    private List<VideoJuego> videojuegos;
}
