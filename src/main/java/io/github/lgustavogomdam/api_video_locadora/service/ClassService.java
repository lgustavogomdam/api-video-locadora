package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ClassRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService extends AbstractService<ClassModel,Long, ClassRepository> {
    @Override
    public void saveValidation(ClassModel model) throws ElementoJaCadastradoException {
        
        //Usado para validar se o model é para atualização ou create
        ClassModel validaClasse = this.repository.findFirstIn(model.getId());
        
        //Usado para validar se o ja existe uma classe com o nome passado
        List<ClassModel> validaClassePorNome = this.repository.findClasseByNome(model.getNome());

        //Valida se o model é nulo o que indica que é create e depois valida se ja nao existe um registro de classe com esse nome
        if (validaClasse == null && validaClassePorNome != null){
            throw new ElementoJaCadastradoException(
                    String.format("A Classe %s já existe no banco de dados!",
                            model.getNome().toUpperCase()));
        }

        //Valida se o elemento a atualizar não é igual ao elemento que ja existe no banco de dados
        if (validaClasse != null && this.seDadosIguais(validaClasse, model)){
            throw new ElementoJaCadastradoException(
                    String.format("Você não atualizou os dados, eles continuam iguais:\n"));
        }
    }
}
