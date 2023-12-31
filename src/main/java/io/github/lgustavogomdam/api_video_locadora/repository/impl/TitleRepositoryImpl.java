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

import java.util.List;

@Repository
public class TitleRepositoryImpl extends AbstractRepositoryImpl<TitleEntity,Long, TitleModel, TitleMapper, TitleJpaRepository> implements TitleRepository {

    public TitleRepositoryImpl(TitleJpaRepository jpaRepository, TitleMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public TitleModel findFirstIn(Long id) {
        TitleModel model = mapper.toModel(this.jpaRepository.findFirstIn(id));
        return model;
    }


    @Override
    public List<TitleModel> findByTerm(String searchTerm){
        List<TitleModel> modelList = mapper.toModelList(jpaRepository.findByTerm(searchTerm));
        return modelList;
    }
}
