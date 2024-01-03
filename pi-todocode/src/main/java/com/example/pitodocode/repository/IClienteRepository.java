package com.example.pitodocode.repository;

import com.example.pitodocode.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);
}
