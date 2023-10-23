package io.github.lgustavogomdam.api_video_locadora.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class DiretorModel implements Serializable {

    private static final Long SerialVersionUID = 1L;
    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @NotBlank
    private String primeiroNome;
    @NotNull
    @NotBlank
    private String ultimoNome;

    public DiretorModel() {
    }

    public DiretorModel(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return this.primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return this.ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
}
