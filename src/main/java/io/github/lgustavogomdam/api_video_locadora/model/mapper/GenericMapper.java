package io.github.lgustavogomdam.api_video_locadora.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface GenericMapper<M, E> {

    M toModel(E entity);

    List<M> toModelList(List<E> entity);


    E fromModel(M model);

    List<E> fromModelList(List<M> model);

}
