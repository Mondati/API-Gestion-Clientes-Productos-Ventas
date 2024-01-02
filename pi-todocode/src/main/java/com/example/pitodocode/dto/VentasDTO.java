package com.example.pitodocode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentasDTO {

    private Long codigo_venta;

    private double Total;
    private int cantidad_de_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentasDTO() {
    }

    public VentasDTO(Long codigo_venta, int cantidad_de_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.cantidad_de_productos = cantidad_de_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }


}
