package com.example.pitodocode.service;

import com.example.pitodocode.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public void saveCliente(Cliente cliente);

    public List<Cliente> getAllClientes();

    public Cliente getCliente(Long id);

    public void deleteCliente(Long id);

    public void editCliente(Long id, Cliente cliente);
}
