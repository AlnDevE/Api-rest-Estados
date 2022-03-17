package com.br.alan.spring.api.controller.dto;

import com.br.alan.spring.api.modelo.Estado;
import com.br.alan.spring.api.modelo.Regiao;
import org.springframework.data.domain.Page;

public class EstadoDto {

    private Long id;
    private String nome;
    private String capital;
    private Long populacao;
    private Regiao regiao;
    private Long area;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.regiao = estado.getRegiao();
        this.capital = estado.getCapital();
        this.populacao = estado.getPopulacao();
        this.area = estado.getArea();
    }

    public static Page<EstadoDto> converte(Page<Estado> estados) {
        return estados.map(EstadoDto::new);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}
