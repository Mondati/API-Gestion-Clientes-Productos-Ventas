package com.example.pitodocode.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

}
