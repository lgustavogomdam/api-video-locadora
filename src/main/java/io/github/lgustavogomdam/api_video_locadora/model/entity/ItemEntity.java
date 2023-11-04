package io.github.lgustavogomdam.api_video_locadora.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "item")
public class ItemEntity implements Serializable {

    public static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_de_serie", length = 300, unique = true, nullable = false)
    private Integer numero_de_serie;

    @Column(name = "titulo", length = 500, nullable = false)
    private String titulo;

    @Column(name = "data_aquisicao")
    @Temporal(value = TemporalType.DATE)
    private Date data_aquisicao;

    @Column(name = "tipo_item",length = 500, nullable = false)
    private String tipo_item;

    public Integer getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(Integer numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
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
