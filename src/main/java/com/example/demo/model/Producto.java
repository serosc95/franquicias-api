package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JsonBackReference
    private Sucursal sucursal;

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
}
