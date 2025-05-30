package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public void delete(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con id: " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Producto updateStock(Long id, int stock) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setStock(stock);
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateName(Long id, String nombre) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setNombre(nombre);
        return productoRepository.save(producto);
    }

    @Override
    public Map<Long, Producto> getProductMaxStock() {
        Map<Long, Producto> resultado = new HashMap<>();
        List<Sucursal> sucursales = sucursalRepository.findAll();

        for (Sucursal sucursal : sucursales) {
            productoRepository.findProductMaxStock(sucursal.getId())
                    .ifPresent(producto -> resultado.put(sucursal.getId(), producto));
        }

        return resultado;
    }
}
