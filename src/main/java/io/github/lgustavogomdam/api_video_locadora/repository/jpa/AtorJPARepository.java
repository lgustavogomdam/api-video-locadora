package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.AtorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AtorJPARepository extends JpaRepository<AtorEntity, Long>{
    @Query("SELECT a FROM AtorEntity a WHERE a.id = :idAtor")
    AtorEntity findFirstIn(@Param("idAtor") Long idAtor);

    @Query("SELECT A FROM AtorEntity A WHERE A.primeiroNome = :primeiroNomeAtor AND A.ultimoNome = :ultimoNomeAtor")
    List<AtorEntity> findAtorByPrimeiroNomeAndUltimoNome(@Param("primeiroNomeAtor") String PrimeiroNomeAtor,
                                                             @Param("ultimoNomeAtor") String ultimoNomeAtor);

}
