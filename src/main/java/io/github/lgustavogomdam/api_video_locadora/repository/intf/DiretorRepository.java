package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DiretorModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends GenericRepository<DiretorModel, Long>{

    List<DiretorModel> findDiretorByPrimeiroNomeAndUltimoNome(String primeiroNomeDiretor, String ultimoNomeDiretor);

}
