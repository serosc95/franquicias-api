package com.example.demo.service;

import com.example.demo.model.Producto;

public interface ProductoService {
    Producto create(Long sucursalId, Producto producto);
}

