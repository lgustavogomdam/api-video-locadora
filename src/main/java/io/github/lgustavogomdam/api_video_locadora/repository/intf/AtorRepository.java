package io.github.lgustavogomdam.api_video_locadora.repository.intf;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.model.entity.AtorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends GenericRepository<AtorModel, Long>{

    List<AtorModel> findAtorByPrimeiroNomeAndUltimoNome(String primeiroNomeAtor, String ultimoNomeAtor);

}
