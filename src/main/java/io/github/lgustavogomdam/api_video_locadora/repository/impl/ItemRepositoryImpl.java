package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ItemEntity;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ItemEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.ItemMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ItemRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.ItemJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl extends AbstractRepositoryImpl<ItemEntity,Long, ItemModel, ItemMapper, ItemJpaRepository> implements ItemRepository {

    public ItemRepositoryImpl(ItemJpaRepository jpaRepository, ItemMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public ItemModel findFirstIn(Long idItem) {
        ItemModel model = mapper.toModel(this.jpaRepository.findFirstIn(idItem));
        return model;
    }
}
