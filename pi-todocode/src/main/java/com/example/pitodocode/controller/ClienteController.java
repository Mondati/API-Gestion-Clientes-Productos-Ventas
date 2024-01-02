package com.example.pitodocode.controller;

import com.example.pitodocode.entity.Cliente;
import com.example.pitodocode.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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

    @PutMapping("/clientes/editar")
    public ResponseEntity<String> editCli(Cliente cliente) {
        clienteService.editCliente(cliente);
        return new ResponseEntity<>("Cliente editado con éxito", HttpStatus.OK);
    }

}
