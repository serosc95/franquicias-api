package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FranquiciaUpdateDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
}