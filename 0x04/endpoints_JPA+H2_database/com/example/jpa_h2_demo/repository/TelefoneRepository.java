package com.example.jpa_h2_demo.repository;

import com.example.jpa_h2_demo.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
