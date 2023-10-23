package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.AtorRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AtorService extends AbstractService<AtorModel, Long, AtorRepository> {
    private Logger logger = Logger.getLogger(AtorService.class.getName());

    @Override
    public void saveValidation(AtorModel model) throws ElementoJaCadastradoException {

        //Usado para verificar se o model é de atualização, ou seja, se ja existe no Database
        AtorModel validaAtor = this.repository.findFirstIn(model.getId());

        //Usado para verificar se já não existe um Ator com esse mesmo nome e sobrenome no banco de dados (Caso de Create)
        List<AtorModel> validaAtorPorNome = this.repository.findAtorByPrimeiroNomeAndUltimoNome(model.getPrimeiroNome(), model.getUltimoNome());

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
