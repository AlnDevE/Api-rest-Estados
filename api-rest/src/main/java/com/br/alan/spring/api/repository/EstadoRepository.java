package com.br.alan.spring.api.repository;

import com.br.alan.spring.api.modelo.Estado;
import com.br.alan.spring.api.modelo.Regiao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Page <Estado> findByRegiao(Regiao regiao, Pageable pageable);
}
