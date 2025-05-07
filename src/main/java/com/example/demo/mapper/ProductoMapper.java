package com.example.demo.mapper;

import com.example.demo.dto.ProductoCreateDTO;
import com.example.demo.model.Producto;

public class ProductoMapper {

    public static Producto fromDto(ProductoCreateDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setStock(dto.getStock());
        return p;
    }
}
