package com.example.apirest.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String categoria;
    private String name;
    private Double precio;
    private Integer stock;
    private String codigo;
}
