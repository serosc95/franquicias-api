package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Franquicia;
import com.example.demo.model.Sucursal;
import com.example.demo.repository.FranquiciaRepository;
import com.example.demo.repository.SucursalRepository;
import com.example.demo.service.SucursalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal create(Long franquiciaId, Sucursal sucursal) {
        Optional<Franquicia> franquiciaOpt = franquiciaRepository.findById(franquiciaId);

        if (franquiciaOpt.isEmpty()) {
            throw new IllegalArgumentException("Franquicia no encontrada con ID: " + franquiciaId);
        }

        sucursal.setFranquicia(franquiciaOpt.get());
        return sucursalRepository.save(sucursal);
    }
}
