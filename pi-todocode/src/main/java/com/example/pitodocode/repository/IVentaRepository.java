package com.example.pitodocode.repository;

import com.example.pitodocode.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    Optional<Venta> findById(Long id);
    Optional<Venta> findByCodigoVenta(Long codigoVenta);
    void deleteByCodigoVenta(Long codigoVenta);
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
    Venta findFirstByOrderByTotalDesc();

}
