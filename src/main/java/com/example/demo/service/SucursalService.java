package com.example.demo.service;

import com.example.demo.model.Sucursal;

public interface SucursalService {
    Sucursal create(Long franquiciaId, Sucursal sucursal);
    Sucursal update(Long id, String nombre);
}
