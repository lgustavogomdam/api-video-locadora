package io.github.lgustavogomdam.api_video_locadora.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class TitleModel implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private Integer ano;

    @NotNull
    @NotBlank
    private String sinopse;

    @NotNull
    @NotBlank
    private String categoria;

    @NotNull
    private ActorModel actor;

    @NotNull
    private DirectorModel director;

    @NotNull
    private ClassModel classe;

    public ActorModel getActor() {
        return this.actor;
    }

    public void setActor(ActorModel actor) {
        this.actor = actor;
    }

    public DirectorModel getDirector() {
        return this.director;
    }

    public void setDirector(DirectorModel director) {
        this.director = director;
    }

    public ClassModel getClasse() {
        return this.classe;
    }

    public void setClasse(ClassModel classe) {
        this.classe = classe;
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


}
