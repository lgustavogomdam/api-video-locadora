package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.ClassEntity;
import io.github.lgustavogomdam.api_video_locadora.model.mapper.ClasseMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ClassRepository;
import io.github.lgustavogomdam.api_video_locadora.repository.jpa.ClasseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRepositoryImpl extends
        AbstractRepositoryImpl<ClassEntity,Long, ClassModel, ClasseMapper, ClasseJpaRepository> implements ClassRepository {

    public ClassRepositoryImpl(ClasseJpaRepository jpaRepository, ClasseMapper mapper) {
        super(jpaRepository, mapper);
    }
    @Override
    public ClassModel save(ClassModel model) {
        return super.saveAndFlush(model);
    }

    @Override
    public ClassModel findFirstIn(Long id) {
        ClassModel model = mapper.toModel(this.jpaRepository.findFirstIn(id));
        return model;
    }

    @Override
    public List<ClassModel> findClasseByNome(String nomeClasse) {
        List<ClassModel> modelList = mapper.toModelList(this.jpaRepository.findClasseByNome(nomeClasse));
        if (modelList.isEmpty())
            return null;
        return modelList;
    }
}
