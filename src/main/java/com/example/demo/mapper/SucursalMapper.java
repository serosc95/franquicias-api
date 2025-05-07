package com.example.demo.mapper;

import com.example.demo.dto.SucursalCreateDTO;
import com.example.demo.model.Sucursal;

public class SucursalMapper {

    public static Sucursal fromDto(SucursalCreateDTO dto) {
        Sucursal s = new Sucursal();
        s.setNombre(dto.getNombre());
        return s;
    }
}
