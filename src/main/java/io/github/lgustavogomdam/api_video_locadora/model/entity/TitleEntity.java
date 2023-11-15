package io.github.lgustavogomdam.api_video_locadora.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "titulo")
public class TitleEntity implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTitle;

    @Column(name = "nome", length = 300, nullable = false)
    private String nome;

    @Column(name = "ano", length = 4, nullable = false)
    private Integer ano;

    @Column(name = "sinopse", length = 2000, nullable = false)
    private String sinopse;

    @Column(name = "categoria", length = 300, nullable = false)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "idActor")
    private ActorEntity actor;

    @ManyToOne
    @JoinColumn(name = "idDirector")
    private DirectorEntity director;

    @ManyToOne
    @JoinColumn(name = "idClass")
    private ClassEntity classe;

    public Long getIdTitle() {
        return this.idTitle;
    }

    public void setIdTitle(Long idTitle) {
        this.idTitle = idTitle;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ActorEntity getActor() {
        return this.actor;
    }

    public void setActor(ActorEntity actor) {
        this.actor = actor;
    }

    public DirectorEntity getDirector() {
        return this.director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }

    public ClassEntity getClasse() {
        return this.classe;
    }

    public void setClasse(ClassEntity classe) {
        this.classe = classe;
    }
}
