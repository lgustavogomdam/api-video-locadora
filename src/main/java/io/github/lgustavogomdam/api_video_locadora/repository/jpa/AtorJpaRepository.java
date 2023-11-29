package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorJpaRepository extends JpaRepository<ActorEntity, Long>{
    @Query("SELECT a FROM ActorEntity a WHERE a.id = :id")
    ActorEntity findFirstIn(@Param("id") Long id);

    @Query("SELECT A FROM ActorEntity A WHERE A.primeiroNome = :primeiroNomeAtor AND A.ultimoNome = :ultimoNomeAtor")
    List<ActorEntity> findAtorByPrimeiroNomeAndUltimoNome(@Param("primeiroNomeAtor") String PrimeiroNomeAtor,
                                                          @Param("ultimoNomeAtor") String ultimoNomeAtor);

}
