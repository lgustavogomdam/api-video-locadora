package io.github.lgustavogomdam.api_video_locadora.model.mapper;

import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.TitleEntity;
import org.mapstruct.Mapper;

@Mapper()
public interface TitleMapper extends GenericMapper<TitleModel, TitleEntity> {
}
