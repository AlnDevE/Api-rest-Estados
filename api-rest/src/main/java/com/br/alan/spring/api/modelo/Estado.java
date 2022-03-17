package com.br.alan.spring.api.modelo;

import javax.persistence.*;

@Entity
public class Estado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String capital;
    private Long populacao;
    private Long area;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;

    public Estado() {
    }

    public Estado(String nome, String capital,Long populacao,Long area,Regiao regiao) {
        this.nome = nome;
        this.capital = capital;
        this.populacao=populacao;
        this.area=area;
        this.regiao = regiao;
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
