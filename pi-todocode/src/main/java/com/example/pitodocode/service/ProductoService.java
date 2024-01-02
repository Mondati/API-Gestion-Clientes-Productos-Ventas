package com.example.pitodocode.service;

import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;
import com.example.pitodocode.repository.IProductoRepository;
import com.example.pitodocode.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;
    private IVentaRepository ventaRepository;

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto listProducto(Long codigo_producto) {
        return productoRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public List<Producto> listAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepository.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public List<Producto> cantidadMenorA5() {

        List<Producto> productoList = this.listAllProducto();
        List<Producto> productosMenorA5 = new ArrayList<>();

        for (Producto pro : productoList) {
            if (pro.getCantidad_disponible() <= 5) {
                productosMenorA5.add(pro);
            }
        }
        return productosMenorA5;
    }


}
