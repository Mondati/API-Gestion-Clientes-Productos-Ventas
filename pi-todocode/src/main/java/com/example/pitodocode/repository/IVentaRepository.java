package com.example.pitodocode.repository;

import com.example.pitodocode.entity.Venta;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    Optional<Venta> findByCodigoVenta(Long codigo_venta);
    void deleteByCodigo(Long codigo_venta);
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
    Venta findFirstByOrderByTotalDesc();

}
