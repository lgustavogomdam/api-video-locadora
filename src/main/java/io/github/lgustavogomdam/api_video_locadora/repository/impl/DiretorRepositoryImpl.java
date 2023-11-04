package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DiretorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.DiretorEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.DiretorMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.DiretorRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.DiretorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiretorRepositoryImpl extends AbstractRepositoryImpl<DiretorEntity,Long, DiretorModel, DiretorMapper, DiretorJpaRepository> implements DiretorRepository {


    public DiretorRepositoryImpl(DiretorJpaRepository jpaRepository, DiretorMapper mapper) {
        super(jpaRepository, mapper);
    }

    @Override
    public DiretorModel save(DiretorModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public DiretorModel findFirstIn(Long idDiretor) {
        DiretorModel model = mapper.toModel(this.jpaRepository.findFirstIn(idDiretor));
        return model;
    }

    @Override
    public List<DiretorModel> findDiretorByPrimeiroNomeAndUltimoNome(String primeiroNomeDiretor, String ultimoNomeDiretor) {
        List<DiretorModel> modelList = (mapper.toModelList(this.jpaRepository.findDiretorByPrimeiroNomeAndUltimoNome(primeiroNomeDiretor, ultimoNomeDiretor)));
        if(modelList.isEmpty())
            return null;

        return modelList;
    }
}
