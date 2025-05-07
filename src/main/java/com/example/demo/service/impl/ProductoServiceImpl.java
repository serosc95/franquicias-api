package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.model.Sucursal;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.SucursalRepository;
import com.example.demo.service.ProductoService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;
    @Override
    public Producto create(Long sucursalId, Producto producto) {
        Optional<Sucursal> sucursalOpt = sucursalRepository.findById(sucursalId);

        if (sucursalOpt.isEmpty()) {
            throw new IllegalArgumentException("Sucursal no encontrada con ID: " + sucursalId);
        }

        producto.setSucursal(sucursalOpt.get());
        return productoRepository.save(producto);
    }
}
