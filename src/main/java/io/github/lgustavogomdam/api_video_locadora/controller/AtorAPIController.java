package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.AtorModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.AtorRepository;
import io.github.lgustavogomdam.api_video_locadora.service.AbstractService;
import io.github.lgustavogomdam.api_video_locadora.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/ator")
public class AtorAPIController extends AbstractAPIController<AtorModel,Long,AtorService>{

    @Override
    @PostMapping
    public ResponseEntity<AtorModel> create(@RequestBody AtorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<AtorModel>(this.service.create(model),HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<AtorModel> update(@RequestBody AtorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<AtorModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        AtorModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O ator %s %s foi deletado com sucesso!",
                model.getPrimeiroNome().toUpperCase(),
                model.getUltimoNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
