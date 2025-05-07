package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Franquicia {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sucursal> sucursales = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
