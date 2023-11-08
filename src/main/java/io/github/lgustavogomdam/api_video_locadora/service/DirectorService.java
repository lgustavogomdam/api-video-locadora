package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.DirectorRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class DirectorService extends AbstractService<DirectorModel, Long, DirectorRepository> {
    private Logger logger = Logger.getLogger(DirectorService.class.getName());

    @Override
    public void saveValidation(DirectorModel model) throws ElementoJaCadastradoException {

        //Usado para verificar se o model é de atualização, ou seja, se ja existe no Database
        DirectorModel validaDiretor = this.repository.findFirstIn(model.getId());

        //Usado para verificar se já não existe um Diretor com esse mesmo nome e sobrenome no banco de dados (Caso de Create)
        List<DirectorModel> validaDiretorPorNome = this.repository.findDiretorByPrimeiroNomeAndUltimoNome(model.getPrimeiroNome(), model.getUltimoNome());

        if (validaDiretor == null && validaDiretorPorNome != null){
            throw new ElementoJaCadastradoException(
                    String.format("O Diretor %s %s já existe no banco de dados!",
                            model.getPrimeiroNome().toUpperCase(), model.getUltimoNome().toUpperCase()));

        }

        if (validaDiretor != null && this.seDadosIguais(validaDiretor, model)){
            throw new ElementoJaCadastradoException(
                    String.format("Você não atualizou os dados, eles continual iguais!:\n" +
                                    "Dados antes: 'primeiroNome': %s - 'ultimoNome': %s\n" +
                                    "Dados depois: 'primeiroNome': %s - 'ultimoNome': %s",
                            model.getPrimeiroNome().toUpperCase(), model.getUltimoNome().toUpperCase(),
                            validaDiretor.getPrimeiroNome().toUpperCase(), validaDiretor.getUltimoNome().toUpperCase()));
        }
    }
}
