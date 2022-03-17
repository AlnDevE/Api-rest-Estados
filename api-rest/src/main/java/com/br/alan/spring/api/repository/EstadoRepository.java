package com.br.alan.spring.api.repository;

import com.br.alan.spring.api.modelo.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Page <Estado> findByNome(String nome, Pageable pageable);
}
