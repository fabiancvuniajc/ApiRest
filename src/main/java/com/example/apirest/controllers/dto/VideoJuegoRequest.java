package com.example.apirest.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoJuegoRequest {

    private String plataforma;
    private String titulo;
    private Double precio;
    private Integer stock;
    private String categoria;
}
