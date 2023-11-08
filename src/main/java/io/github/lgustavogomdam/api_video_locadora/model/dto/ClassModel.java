package io.github.lgustavogomdam.api_video_locadora.model.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class ClassModel {
    private static final Long SerialVersionUID = 1L;

    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Double valor;
    private Date dataDevolucao;

    public ClassModel() {
    }

    public ClassModel(String nome, Double valor, Date dataDevolucao) {
        this.nome = nome;
        this.valor = valor;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
