package com.example.demo.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Franquicia;
import com.example.demo.repository.FranquiciaRepository;
import com.example.demo.service.FranquiciaService;

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
}

