package com.br.alan.spring.api.controller.form;
import com.br.alan.spring.api.modelo.Estado;
import com.br.alan.spring.api.modelo.Regiao;
import com.br.alan.spring.api.repository.EstadoRepository;
import com.sun.istack.NotNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class EstadoForm {

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty
    private String capital;

    @NotNull
    private Long populacao;

    @NotNull
    private Long area;

    @Enumerated(EnumType.STRING)
    private Regiao regiao;

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

    public Estado converter() {
        return  new Estado(nome,capital,populacao,area,regiao);
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getById(id);

        estado.setNome(this.nome);
        estado.setCapital(this.capital);
        estado.setRegiao(this.regiao);
        estado.setPopulacao(this.populacao);
        estado.setArea(this.area);

        return estado;
    }
}
