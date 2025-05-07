package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Franquicia;

public interface FranquiciaService {
    List<Franquicia> findAll();
    Franquicia create(Franquicia f);
    Franquicia update(Long id, String nombre);
}

