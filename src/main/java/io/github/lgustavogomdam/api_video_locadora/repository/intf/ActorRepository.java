package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends GenericRepository<ActorModel, Long>{

    List<ActorModel> findAtorByPrimeiroNomeAndUltimoNome(String primeiroNomeAtor, String ultimoNomeAtor);

}
