package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClasseModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.AtorEntity;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ClasseEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.ClasseMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ClasseRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.ClasseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClasseRepositoryImpl extends
        AbstractRepositoryImpl<ClasseEntity,Long, ClasseModel, ClasseMapper, ClasseJpaRepository> implements ClasseRepository {

    public ClasseRepositoryImpl(ClasseJpaRepository jpaRepository, ClasseMapper mapper) {
        super(jpaRepository, mapper);
    }
    @Override
    public ClasseModel save(ClasseModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public ClasseModel findFirstIn(Long idClasse) {
        ClasseModel model = mapper.toModel(this.jpaRepository.findFirstIn(idClasse));
        return model;
    }

    @Override
    public List<ClasseModel> findClasseByNome(String nomeClasse) {
        List<ClasseModel> modelList = mapper.toModelList(this.jpaRepository.findClasseByNome(nomeClasse));
        if (modelList.isEmpty())
            return null;
        return modelList;
    }
}
