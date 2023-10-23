package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DiretorModel;
import io.github.lgustavogomdam.api_video_locadora.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/diretor")
public class DiretorAPIController extends AbstractAPIController<DiretorModel,Long,DiretorService>{

    @Override
    public ResponseEntity<DiretorModel> create(@RequestBody DiretorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<DiretorModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DiretorModel> update(@RequestBody DiretorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<DiretorModel>(this.service.update(model),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        DiretorModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O Diretor %s %s foi deletado com sucesso!",
                model.getPrimeiroNome().toUpperCase(),
                model.getUltimoNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
