package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.TitleEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.ItemMapper;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.TitleMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.TitleRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.ItemJpaRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.TitleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TitleRepositoryImpl extends AbstractRepositoryImpl<TitleEntity,Long, TitleModel, TitleMapper, TitleJpaRepository> implements TitleRepository {

    public TitleRepositoryImpl(TitleJpaRepository jpaRepository, TitleMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public TitleModel findFirstIn(Long idTitle) {
        TitleModel model = mapper.toModel(this.jpaRepository.findFirstIn(idTitle));
        return model;
    }
}
