package com.example.pitodocode.service;

import com.example.pitodocode.dto.VentaDTO;
import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void saveVenta(Venta venta);
    public List<Venta> getAllVentas();
    public Venta getVenta (Long codigoVenta);
    public void deleteVenta(Long codigoVenta);
    public void editVenta(Venta venta);
    public List<Producto> productosXVenta(Long id);
    public String montoXCantidadXDia(LocalDate fechaVenta);
    public VentaDTO obtenerVentaConValorMasAlto();
}
