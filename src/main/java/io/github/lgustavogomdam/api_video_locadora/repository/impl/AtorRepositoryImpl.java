package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.AtorEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.AtorMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.AtorRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.AtorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AtorRepositoryImpl extends AbstractRepositoryImpl<AtorEntity,Long, AtorModel, AtorMapper, AtorJpaRepository> implements AtorRepository {

    public AtorRepositoryImpl(AtorJpaRepository jpaRepository, AtorMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public AtorModel save(AtorModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public AtorModel findFirstIn(Long idAtor) {
        AtorModel model = mapper.toModel(this.jpaRepository.findFirstIn(idAtor));
        return model;
    }

    @Override
    public List<AtorModel> findAtorByPrimeiroNomeAndUltimoNome(String primeiroNomeAtor, String ultimoNomeAtor) {
        List<AtorModel> modelList = (mapper.toModelList(this.jpaRepository.findAtorByPrimeiroNomeAndUltimoNome(primeiroNomeAtor, ultimoNomeAtor)));
        if(modelList.isEmpty())
            return null;

        return modelList;
    }
}
