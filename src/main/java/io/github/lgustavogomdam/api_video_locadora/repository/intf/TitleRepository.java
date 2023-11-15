package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends GenericRepository<TitleModel,Long> {
}
