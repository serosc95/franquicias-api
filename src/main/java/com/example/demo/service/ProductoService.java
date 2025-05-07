package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.Producto;

public interface ProductoService {
    Producto create(Long sucursalId, Producto producto);
    void delete(Long id);
    Producto update(Long id, int stock);
    Map<Long, Producto> getProductMaxStock();
}

