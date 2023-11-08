package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.DirectorEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.DiretorMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.DirectorRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.DiretorJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepositoryImpl extends AbstractRepositoryImpl<DirectorEntity,Long, DirectorModel, DiretorMapper, DiretorJpaRepository> implements DirectorRepository {


    public DirectorRepositoryImpl(DiretorJpaRepository jpaRepository, DiretorMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public DirectorModel save(DirectorModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public DirectorModel findFirstIn(Long idDiretor) {
        DirectorModel model = mapper.toModel(this.jpaRepository.findFirstIn(idDiretor));
        return model;
    }

    @Override
    public List<DirectorModel> findDiretorByPrimeiroNomeAndUltimoNome(String primeiroNomeDiretor, String ultimoNomeDiretor) {
        List<DirectorModel> modelList = (mapper.toModelList(this.jpaRepository.findDiretorByPrimeiroNomeAndUltimoNome(primeiroNomeDiretor, ultimoNomeDiretor)));
        if(modelList.isEmpty())
            return null;

        return modelList;
    }
}
