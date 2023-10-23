package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClasseModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClasseModel;
import io.github.lgustavogomdam.api_video_locadora.service.ClasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/classe")
public class ClasseAPIController extends AbstractAPIController<ClasseModel,Long, ClasseService>{

    @Override
    public ResponseEntity<ClasseModel> create(@RequestBody ClasseModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<ClasseModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClasseModel> update(@RequestBody ClasseModel model) {
        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");

        return new ResponseEntity<ClasseModel>(this.service.update(model), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        ClasseModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "A Classe %s foi deletado com sucesso!",
                model.getNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
