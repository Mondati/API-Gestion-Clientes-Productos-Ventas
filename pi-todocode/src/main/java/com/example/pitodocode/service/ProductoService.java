package com.example.pitodocode.service;

import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.repository.IProductoRepository;
import com.example.pitodocode.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        return productoRepository.findByCodigoProducto(codigo_producto).orElse(null);
    }

    @Override
    public List<Producto> listAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProducto(Long codigo_producto) {
        productoRepository.deleteByCodigoProducto(codigo_producto);
    }

    @Override
    public void editProducto(Long id, Producto producto) {
        Optional<Producto> productoBuscado = productoRepository.findById(id);
        if (productoBuscado.isPresent()) {
            Producto productoExistente = productoBuscado.get();
            productoExistente.setCodigoProducto(producto.getCodigoProducto());
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setMarca(producto.getMarca());
            productoExistente.setCosto(producto.getCosto());
            productoExistente.setCantidad_disponible(producto.getCantidad_disponible());

            productoRepository.save(productoExistente);

        } else {
            throw new NoSuchElementException("Producto no encontrado con ID: " + id);
        }
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
