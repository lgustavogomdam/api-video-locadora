package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.DiretorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorJpaRepository extends JpaRepository<DiretorEntity, Long>{
    @Query("SELECT a FROM DiretorEntity a WHERE a.id = :idDiretor")
    DiretorEntity findFirstIn(@Param("idDiretor") Long idDiretor);

    @Query("SELECT A FROM DiretorEntity A WHERE A.primeiroNome = :primeiroNomeDiretor AND A.ultimoNome = :ultimoNomeDiretor")
    List<DiretorEntity> findDiretorByPrimeiroNomeAndUltimoNome(@Param("primeiroNomeDiretor") String PrimeiroNomeDiretor,
                                                             @Param("ultimoNomeDiretor") String ultimoNomeDiretor);

}
