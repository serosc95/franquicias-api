package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ProductoUpdateDTO {

    private String nombre;
    
    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;
}