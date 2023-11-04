package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.repository.intf.GenericRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public abstract class AbstractService<M, K, R extends GenericRepository<M,K>> {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    protected R repository;

    public List<M> findAll() {
        return this.repository.findAll();
    }

    public M findById(K id){
        try{
            return this.repository.findById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public M create(M model){
        try {
            saveValidation(model);
        } catch (ElementoJaCadastradoException e) {
            throw new RuntimeException(e);
        }
        return this.repository.saveAndFlush(model);
    }

    public M update(M model){
        try {
            saveValidation(model);
        } catch (ElementoJaCadastradoException e) {
            throw new RuntimeException(e);
        }
        return this.repository.save(model);
    }

    public void softDelete(K id){
        try{
            M model = this.repository.findById(id);
            this.repository.softDelete(model);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public abstract void saveValidation(M model) throws ElementoJaCadastradoException;

    protected boolean seDadosIguais(M modelTarget, M modelCounterTarget){

        if (modelTarget.getClass() != modelCounterTarget.getClass()) {
            return false;
        }

        // Declara uma variável chamada classe do tipo Class<?>. O ? é um tipo genérico wildcard, o que significa que
        // classe pode se referir a qualquer classe. Neste caso, classe é uma referência para a classe da qual objetoA
        // é uma instância.
        Class<?> classe = modelTarget.getClass();

        // Declara um Array de Fields que conterá todos os atributos da variável classe definida na instrução anterior
        Field[] atributos = classe.getDeclaredFields();

        //Anda na lista de atributos validando cada um dos atributos
        for (Field atributo : atributos) {

            //troca o modificador de acesso para que o atributo possa ser lido (no caso de ser private ou protected)
            atributo.setAccessible(true);

            Object valorA = null;
            Object valorB = null;

            //Recebe o valor do atributo atual da entidade passada como parametro
            try {
                valorA = atributo.get(modelTarget);
                valorB = atributo.get(modelCounterTarget);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao verificar os atributos da classe!");
            }

            if (valorA == null && valorB == null) {
                continue;
            }

            if (atributo.getClass().equals(Double.class) || atributo.getClass().equals(Integer.class)){
                if ((valorA == null && valorB != null) || valorA != valorB) {
                    return false;
                }
            } else if (atributo.getClass().equals(Date.class)) {
                if ((valorA == null && valorB != null) || Date.valueOf(valorA.toString()).compareTo(Date.valueOf(valorB.toString())) != 0){
                    return false;
                }
            }else{
                if ((valorA == null && valorB != null) || !valorA.equals(valorB)){
                    return false;
                }
            }
        }
        return true;
    }
}
