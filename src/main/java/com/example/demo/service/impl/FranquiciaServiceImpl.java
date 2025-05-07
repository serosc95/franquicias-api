package com.example.demo.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Franquicia;
import com.example.demo.repository.FranquiciaRepository;
import com.example.demo.service.FranquiciaService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    @Override
    public List<Franquicia> findAll() {
        return franquiciaRepository.findAll();
    }

    @Override
    public Franquicia create(Franquicia f) {
        return franquiciaRepository.save(f);
    }

    @Override
    public Franquicia update(Long id, String nombre) {
        Franquicia franquicia = franquiciaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada con ID: " + id));

        franquicia.setNombre(nombre);
        return franquiciaRepository.save(franquicia);   
    }
}

