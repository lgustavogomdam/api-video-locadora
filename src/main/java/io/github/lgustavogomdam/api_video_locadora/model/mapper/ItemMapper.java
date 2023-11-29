package io.github.lgustavogomdam.api_video_locadora.model.mapper;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper()
public interface ItemMapper extends GenericMapper<ItemModel, ItemEntity> {

}
