package com.example.pitodocode.service;

import com.example.pitodocode.dto.VentasDTO;
import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;
import com.example.pitodocode.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVenta(Long codigoVenta) {
        return ventaRepository.findByCodigoVenta(codigoVenta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        ventaRepository.deleteByCodigoVenta(codigoVenta);
    }

    @Override
    public void editVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List<Producto> productosXVenta(Long id) {
        Optional<Venta> ventaOptional = ventaRepository.findById(id);

        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            return venta.getListaProductos();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String montoXCantidadXDia(LocalDate fechaVenta) {
        List<Venta> ventasDelDia = ventaRepository.findByFechaVenta(fechaVenta);

        Double sumatoriaMonto = 0.0;
        int cantidadTotalVentas = ventasDelDia.size();

        for (Venta venta : ventasDelDia) {
            sumatoriaMonto += venta.getTotal();
        }
        return "La sumatoria del monto del dia es: " + sumatoriaMonto + "y la cantidad total de ventas fueron: " + cantidadTotalVentas;

    }

    @Override
    public VentasDTO obtenerVentaConValorMasAlto() {
        Venta ventaConMontoMasAlto = ventaRepository.findFirstByOrderByTotalDesc();
        if (ventaConMontoMasAlto != null) {
            VentasDTO ventasDTO = new VentasDTO();
            ventasDTO.setCodigo_venta(ventaConMontoMasAlto.getCodigoVenta());
            ventasDTO.setTotal(ventaConMontoMasAlto.getTotal());
            ventasDTO.setCantidad_de_productos(ventaConMontoMasAlto.getListaProductos().size());
            ventasDTO.setNombre_cliente(ventaConMontoMasAlto.getUnCliente().getNombre());
            ventasDTO.setApellido_cliente(ventaConMontoMasAlto.getUnCliente().getApellido());
            return ventasDTO;
        }
        return null;
    }

}