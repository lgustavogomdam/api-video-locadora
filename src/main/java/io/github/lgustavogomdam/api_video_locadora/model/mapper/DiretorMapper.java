package io.github.lgustavogomdam.api_video_locadora.model.mapper;


import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.DirectorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiretorMapper extends GenericMapper<DirectorModel, DirectorEntity>{

}
