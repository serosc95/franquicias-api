package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("""
        SELECT p FROM Producto p
        WHERE p.sucursal.id = :sucursalId
        AND p.stock = (
            SELECT MAX(p2.stock)
            FROM Producto p2
            WHERE p2.sucursal.id = :sucursalId
        )
        """)
    Optional<Producto> findProductMaxStock(@Param("sucursalId") Long sucursalId);
}
