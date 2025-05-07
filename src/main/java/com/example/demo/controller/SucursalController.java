package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SucursalCreateDTO;
import com.example.demo.mapper.SucursalMapper;
import com.example.demo.model.Sucursal;
import com.example.demo.service.SucursalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sucursal")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping("/franquicia/{franquiciaId}")
    public ResponseEntity<Sucursal> createSucursal(@PathVariable Long franquiciaId, @Valid @RequestBody SucursalCreateDTO dto) {
        Sucursal s = SucursalMapper.fromDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.create(franquiciaId, s));
    }
}
