package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.ClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseJpaRepository extends JpaRepository<ClasseEntity,Long> {

    @Query("SELECT c FROM ClasseEntity c WHERE c.id = :idClasse")
    ClasseEntity findFirstIn(@Param("idClasse") Long idClasse);

    @Query("SELECT C FROM ClasseEntity C WHERE C.nome = :nomeClasse")
    List<ClasseEntity> findClasseByNome(@Param("nomeClasse") String nomeClasse);
}
