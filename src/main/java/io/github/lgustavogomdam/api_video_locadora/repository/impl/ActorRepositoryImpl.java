package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ActorEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.AtorMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ActorRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.AtorJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorRepositoryImpl extends AbstractRepositoryImpl<ActorEntity,Long, ActorModel, AtorMapper, AtorJpaRepository> implements ActorRepository {

    public ActorRepositoryImpl(AtorJpaRepository jpaRepository, AtorMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public ActorModel save(ActorModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public ActorModel findFirstIn(Long idAtor) {
        ActorModel model = mapper.toModel(this.jpaRepository.findFirstIn(idAtor));
        return model;
    }

    @Override
    public List<ActorModel> findAtorByPrimeiroNomeAndUltimoNome(String primeiroNomeAtor, String ultimoNomeAtor) {
        List<ActorModel> modelList = (mapper.toModelList(this.jpaRepository.findAtorByPrimeiroNomeAndUltimoNome(primeiroNomeAtor, ultimoNomeAtor)));
        if(modelList.isEmpty())
            return null;

        return modelList;
    }
}
