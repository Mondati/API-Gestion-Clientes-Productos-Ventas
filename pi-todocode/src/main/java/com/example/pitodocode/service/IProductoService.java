package com.example.pitodocode.service;

import com.example.pitodocode.entity.Producto;

import java.util.List;

public interface IProductoService {

    public void saveProducto(Producto producto);

    public Producto listProducto(Long codigo_producto);

    public List<Producto> listAllProducto();

    public void deleteProducto(Long codigo_producto);

    public void editProducto(Producto producto);

    public List<Producto> cantidadMenorA5();

}
