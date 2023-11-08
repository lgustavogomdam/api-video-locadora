package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends GenericRepository<ClassModel, Long>{

    List<ClassModel> findClasseByNome(String nomeClasse);

}
