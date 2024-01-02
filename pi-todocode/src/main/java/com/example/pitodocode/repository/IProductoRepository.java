package com.example.pitodocode.repository;

import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
