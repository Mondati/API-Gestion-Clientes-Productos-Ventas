package com.example.pitodocode.controller;

import com.example.pitodocode.entity.Cliente;
import com.example.pitodocode.service.ClienteService;
import com.example.pitodocode.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/clientes/crear")
    public ResponseEntity<String> saveCli(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return new ResponseEntity<>("Cliente creado con éxito", HttpStatus.OK);
    }

    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> getAllCli() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCli(@PathVariable  Long id_cliente){
        return clienteService.getCliente(id_cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public ResponseEntity<String> deleteCli(@PathVariable Long id_cliente) {
        clienteService.deleteCliente(id_cliente);
        return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.OK);
    }

    @PutMapping("clientes/editar/{id}")
    public ResponseEntity<String> editarCliente(@PathVariable Long id, @RequestBody Cliente clienteDatosNuevos) {
        try {
            clienteService.editCliente(id, clienteDatosNuevos);
            return ResponseEntity.ok("Cliente editado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}


