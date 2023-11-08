package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.service.DirectorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/director")
@Tag(name = "Diretor", description = "Endpoints for managing Diretor")
public class DirectorAPIController extends AbstractAPIController<DirectorModel,Long, DirectorService>{

    @Override
    @GetMapping()
    public List<DirectorModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<DirectorModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    public ResponseEntity<DirectorModel> create(@RequestBody DirectorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<DirectorModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    @PutMapping()
    public ResponseEntity<DirectorModel> update(@RequestBody DirectorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<DirectorModel>(this.service.update(model),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        DirectorModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O Diretor %s %s foi deletado com sucesso!",
                model.getPrimeiroNome().toUpperCase(),
                model.getUltimoNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
