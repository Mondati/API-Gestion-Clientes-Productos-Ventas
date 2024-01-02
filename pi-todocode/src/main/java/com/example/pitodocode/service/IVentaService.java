package com.example.pitodocode.service;

import com.example.pitodocode.dto.VentasDTO;
import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void saveVenta(Venta venta);
    public List<Venta> getAllVentas();
    public Venta getVenta (Long codigo_venta);
    public void deleteVenta(Long codigo_venta);
    public void editVenta(Venta venta);
    public List<Producto> productosXVenta(Long id);
    public String montoXCantidadXDia(LocalDate fecha_venta);
    public VentasDTO obtenerVentaConValorMasAlto();
}
