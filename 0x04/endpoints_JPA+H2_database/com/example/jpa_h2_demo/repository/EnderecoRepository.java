package com.example.jpa_h2_demo.repository;

import com.example.jpa_h2_demo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
