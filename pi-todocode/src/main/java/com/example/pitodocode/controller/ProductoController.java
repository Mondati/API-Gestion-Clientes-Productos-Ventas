package com.example.pitodocode.controller;

import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos/crear")
    public ResponseEntity<String> savePro(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return new ResponseEntity<>("Producto creado con éxito", HttpStatus.OK);
    }

    @GetMapping("/productos")
    @ResponseBody
    public List<Producto> allProducts() {
        return productoService.listAllProducto();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto findPro(@PathVariable Long codigo_producto) {
        return productoService.listProducto(codigo_producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> stockMenorA5() {
        return productoService.cantidadMenorA5();
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public ResponseEntity<String> deletePro(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
        return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
    }

    @PutMapping("/productos/editar/{id}")
    public ResponseEntity<String> editPro(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            productoService.editProducto(id, producto);
            return ResponseEntity.ok("Producto editado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

}
