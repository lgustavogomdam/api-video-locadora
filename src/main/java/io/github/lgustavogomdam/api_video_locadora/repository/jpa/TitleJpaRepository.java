package io.github.lgustavogomdam.api_video_locadora.repository.jpa;

import io.github.lgustavogomdam.api_video_locadora.model.entity.ItemEntity;
import io.github.lgustavogomdam.api_video_locadora.model.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleJpaRepository extends JpaRepository<TitleEntity,Long> {

    @Query("SELECT a FROM TitleEntity a WHERE a.idTitle = :idTitle")
    TitleEntity findFirstIn(@Param("idTitle") Long idTitle);
}
