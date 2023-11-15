package io.github.lgustavogomdam.api_video_locadora.model.entity;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ator")
public class ActorEntity implements Serializable {

    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActor;

    @Column(name = "primeiro_nome", length = 50, nullable = false)
    private String primeiroNome;

    @Column(name = "ultimo_nome", length = 50, nullable = false)
    private String ultimoNome;

    public ActorEntity() {
    }

    public void setId(Long id) {
        this.idActor = id;
    }

    public Long getId() {
        return this.idActor;
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
