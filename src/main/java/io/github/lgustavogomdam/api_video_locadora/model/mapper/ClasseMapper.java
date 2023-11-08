package io.github.lgustavogomdam.api_video_locadora.model.mapper;


import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ClassEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClasseMapper extends GenericMapper<ClassModel, ClassEntity>{

}
