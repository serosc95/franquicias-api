package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductoCreateDTO;
import com.example.demo.dto.ProductoUpdateDTO;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<Producto> createProducto(@PathVariable Long sucursalId, @Valid @RequestBody ProductoCreateDTO dto) {
        Producto p = ProductoMapper.fromDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.create(sucursalId, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody ProductoUpdateDTO dto) {

        Producto productoUpdate = productoService.update(id, dto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productoUpdate);
    }
}
