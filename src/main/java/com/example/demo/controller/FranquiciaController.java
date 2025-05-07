package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FranquiciaCreateDTO;
import com.example.demo.dto.FranquiciaUpdateDTO;
import com.example.demo.mapper.FranquiciaMapper;
import com.example.demo.model.Franquicia;
import com.example.demo.service.FranquiciaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/franquicia")
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @GetMapping
    public ResponseEntity<List<Franquicia>> findAllFranquicia() {
        return ResponseEntity.ok(franquiciaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Franquicia> createFranquicia(@Valid @RequestBody FranquiciaCreateDTO dto) {
        Franquicia f = FranquiciaMapper.fromDto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(franquiciaService.create(f));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Franquicia> updateFranquicia(@PathVariable Long id, @Valid @RequestBody FranquiciaUpdateDTO dto) {

        Franquicia franquiciaUpdate = franquiciaService.update(id, dto.getNombre());
        return ResponseEntity.status(HttpStatus.OK).body(franquiciaUpdate);
    }
}
