package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoNaoEncontradoException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface GenericRepository<M,K> {
    public M save(M model);
    public M saveAndFlush(M model);
    public List<M> findAll();
    public M findById(K id) throws ElementoNaoEncontradoException;
    public void softDelete(M model);
    public M findFirstIn(K id);

}
