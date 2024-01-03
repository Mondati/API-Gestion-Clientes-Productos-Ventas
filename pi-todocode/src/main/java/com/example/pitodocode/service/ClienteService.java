package com.example.pitodocode.service;

import com.example.pitodocode.entity.Cliente;
import com.example.pitodocode.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void editCliente(Long id, Cliente cliente)  {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente clienteExistente = clienteOptional.get();
            // Actualiza los campos del cliente existente con los datos nuevos
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setDni(cliente.getDni());
            clienteRepository.save(clienteExistente);
        } else {
            throw new NoSuchElementException("Cliente no encontrado con ID: " + id);
        }
    }
}

