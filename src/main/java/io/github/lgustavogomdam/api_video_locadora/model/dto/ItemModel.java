package io.github.lgustavogomdam.api_video_locadora.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;

public class ItemModel implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    private Integer numero_de_serie;

    @NotNull
    private TitleModel titulo;

    @NotNull
    private Date data_aquisicao;

    @NotNull
    @NotBlank
    private String tipo_item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(Integer numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public TitleModel getTitulo() {
        return titulo;
    }

    public void setTitulo(TitleModel titulo) {
        this.titulo = titulo;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public String getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(String tipo_item) {
        this.tipo_item = tipo_item;
    }
}
