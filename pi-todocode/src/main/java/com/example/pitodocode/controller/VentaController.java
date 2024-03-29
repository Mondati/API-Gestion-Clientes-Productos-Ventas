package com.example.pitodocode.controller;

import com.example.pitodocode.dto.VentaDTO;
import com.example.pitodocode.entity.Producto;
import com.example.pitodocode.entity.Venta;
import com.example.pitodocode.service.IVentaService;
import com.example.pitodocode.service.VentaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping("/crear")
    public ResponseEntity<String> saveVenta(@RequestBody Venta venta) {
        ventaService.saveVenta(venta);
        return new ResponseEntity<>("Venta creada con éxito", HttpStatus.OK);
    }

    @GetMapping("/listar-todas")
    @ResponseBody
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{codigo_venta}")
    @ResponseBody
    public Venta getVenta(@PathVariable Long codigo_venta) {
        return ventaService.getVenta(codigo_venta);
    }

    @GetMapping("/productos/{id}")
    @ResponseBody
    public ResponseEntity<List<Producto>> productosXVenta(@PathVariable Long id) {
        List<Producto> productos = ventaService.productosXVenta(id);

        if (!productos.isEmpty()) {
            return ResponseEntity.ok(productos);
        } else {
            // Manejo de error si la venta no se encuentra
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mayor_venta")
    public ResponseEntity<VentaDTO> obtenerVentaConMontoMasAlto() {
        VentaDTO ventaDTO = ventaService.obtenerVentaConValorMasAlto();

        if (ventaDTO != null) {
            return ResponseEntity.ok(ventaDTO);
        } else {
            return ResponseEntity.notFound().build(); // Manejo de caso cuando no hay ventas
        }
    }

    @GetMapping("/monto-cantidad-dia")
    public String montoXCantidadXDia(@RequestParam("fechaVenta") LocalDate fechaVenta) {
        return ventaService.montoXCantidadXDia(fechaVenta);
    }

    @Transactional
    @DeleteMapping("/eliminar/{codigo_venta}")
    public ResponseEntity<String> deleteVenta(@PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return new ResponseEntity<>("Venta eliminada con éxito", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editVenta(@PathVariable Long id, @RequestBody Venta venta) {
        try {
            ventaService.editVenta(id, venta);
            return ResponseEntity.ok("Venta editada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrado");
        }
    }

}
