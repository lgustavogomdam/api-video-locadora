package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClasseModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.AtorEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends GenericRepository<ClasseModel, Long>{

    List<ClasseModel> findClasseByNome(String nomeClasse);

}
