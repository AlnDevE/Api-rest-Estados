package com.br.alan.spring.api.repository;

import com.br.alan.spring.api.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNome(String nome);
}
