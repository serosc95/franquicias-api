package com.example.demo.mapper;

import com.example.demo.dto.FranquiciaCreateDTO;
import com.example.demo.model.Franquicia;

public class FranquiciaMapper {

    public static Franquicia fromDto(FranquiciaCreateDTO dto) {
        Franquicia f = new Franquicia();
        f.setNombre(dto.getNombre());
        return f;
    }
}
