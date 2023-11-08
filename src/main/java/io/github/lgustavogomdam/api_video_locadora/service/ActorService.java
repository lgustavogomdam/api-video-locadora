package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ActorRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ActorService extends AbstractService<ActorModel, Long, ActorRepository> {
    private Logger logger = Logger.getLogger(ActorService.class.getName());

    @Override
    public void saveValidation(ActorModel model) throws ElementoJaCadastradoException {

        //Usado para verificar se o model é de atualização, ou seja, se ja existe no Database
        ActorModel validaAtor = this.repository.findFirstIn(model.getId());

        //Usado para verificar se já não existe um Ator com esse mesmo nome e sobrenome no banco de dados (Caso de Create)
        List<ActorModel> validaAtorPorNome = this.repository.findAtorByPrimeiroNomeAndUltimoNome(model.getPrimeiroNome(), model.getUltimoNome());

        if (validaAtor == null && validaAtorPorNome != null){
            throw new ElementoJaCadastradoException(
                    String.format("O ator %s %s já existe no banco de dados!",
                            model.getPrimeiroNome().toUpperCase(), model.getUltimoNome().toUpperCase()));

        }

        //Valida se o elemento a atualizar não é igual ao elemento que ja existe no banco de dados
        if (validaAtor != null && this.seDadosIguais(validaAtor, model)){
            throw new ElementoJaCadastradoException(
                    String.format("Você não atualizou os dados, eles continuam iguais!:\n"));
        }
    }
}
