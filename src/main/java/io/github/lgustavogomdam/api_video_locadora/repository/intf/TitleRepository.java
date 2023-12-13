package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.TitleEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends GenericRepository<TitleModel,Long> {

    List<TitleModel> findByTerm(String searchTerm);

}
