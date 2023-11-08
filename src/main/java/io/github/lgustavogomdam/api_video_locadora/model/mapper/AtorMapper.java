package io.github.lgustavogomdam.api_video_locadora.model.mapper;


import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;


import io.github.lgustavogomdam.api_video_locadora.model.entity.ActorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AtorMapper extends GenericMapper<ActorModel, ActorEntity>{

}
