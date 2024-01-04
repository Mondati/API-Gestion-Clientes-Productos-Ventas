package com.example.pitodocode.repository;

import com.example.pitodocode.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findById(Long id);
    Optional<Producto>findByCodigoProducto(Long codigo_producto);
    void deleteByCodigoProducto(Long codigo_producto);
}
