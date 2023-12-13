package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.ItemEntity;
import io.github.lgustavogomdam.api_video_locadora.model.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleJpaRepository extends JpaRepository<TitleEntity,Long> {

    @Query("SELECT a FROM TitleEntity a WHERE a.id = :id")
    TitleEntity findFirstIn(@Param("id") Long id);

    @Query("SELECT t FROM TitleEntity t " +
            "JOIN t.actor a " +
            "WHERE t.nome LIKE %:searchTerm% " +
            "   OR a.primeiroNome LIKE %:searchTerm% " +
            "   OR a.ultimoNome LIKE %:searchTerm% " +
            "   OR t.categoria LIKE %:searchTerm%")
    List<TitleEntity> findByTerm(@Param("searchTerm") String searchTerm);

}
