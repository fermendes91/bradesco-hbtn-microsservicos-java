package com.example.jpa_h2_demo.repository;

import com.example.jpa_h2_demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
