package io.github.lgustavogomdam.api_video_locadora.repository.impl;

import io.github.lgustavogomdam.api_video_locadora.model.mapper.GenericMapper;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.GenericRepository;

import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoRepositoryBean
@RequiredArgsConstructor
public abstract class AbstractRepositoryImpl<E,K,M,MP extends GenericMapper<M,E>, JR extends JpaRepository<E,K>> implements GenericRepository<M,K> {

    protected final JR jpaRepository;
    protected final MP mapper;
    @Override
    public M save(M model) {
        return mapper.toModel(jpaRepository.save(mapper.fromModel(model)));
    }
    @Override
    public M saveAndFlush(M model) {
        return mapper.toModel(jpaRepository.saveAndFlush(mapper.fromModel(model)));
    }

    @Override
    public List<M> findAll() {
        return (List<M>) jpaRepository.findAll();
    }
    @Override
    public M findById(K id) throws ElementoNaoEncontradoException {

        E e = jpaRepository.findById(id).orElse(null);
        if (e == null)
            throw new ElementoNaoEncontradoException("Registro não encontrado");

        return mapper.toModel(jpaRepository.findById(id).orElse(null));
    }

    @Override
    public void softDelete(M model) {
        jpaRepository.delete(mapper.fromModel(model));
    }

//    public List<M> findByAttribute(HashMap<String, Object> map){}

}
