package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorJpaRepository extends JpaRepository<DirectorEntity, Long>{
    @Query("SELECT a FROM DirectorEntity a WHERE a.id = :id")
    DirectorEntity findFirstIn(@Param("id") Long id);

    @Query("SELECT A FROM DirectorEntity A WHERE A.primeiroNome = :primeiroNomeDiretor AND A.ultimoNome = :ultimoNomeDiretor")
    List<DirectorEntity> findDiretorByPrimeiroNomeAndUltimoNome(@Param("primeiroNomeDiretor") String PrimeiroNomeDiretor,
                                                                @Param("ultimoNomeDiretor") String ultimoNomeDiretor);

}
