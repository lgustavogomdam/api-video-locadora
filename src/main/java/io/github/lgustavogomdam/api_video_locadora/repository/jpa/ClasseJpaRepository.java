package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseJpaRepository extends JpaRepository<ClassEntity,Long> {

    @Query("SELECT c FROM ClassEntity c WHERE c.id = :idClasse")
    ClassEntity findFirstIn(@Param("idClasse") Long idClasse);

    @Query("SELECT C FROM ClassEntity C WHERE C.nome = :nomeClasse")
    List<ClassEntity> findClasseByNome(@Param("nomeClasse") String nomeClasse);
}
