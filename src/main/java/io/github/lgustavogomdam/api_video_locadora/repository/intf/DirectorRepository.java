package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends GenericRepository<DirectorModel, Long>{

    List<DirectorModel> findDiretorByPrimeiroNomeAndUltimoNome(String primeiroNomeDiretor, String ultimoNomeDiretor);

}
