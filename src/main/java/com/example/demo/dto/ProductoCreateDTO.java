package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;
}