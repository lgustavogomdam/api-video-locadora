package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.service.ClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/class")
@Tag(name = "Classe", description = "Endpoints for managing Classe")
public class ClassAPIController extends AbstractAPIController<ClassModel,Long, ClassService>{

    @Override
    @GetMapping()
    public List<ClassModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<ClassModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    public ResponseEntity<ClassModel> create(@RequestBody ClassModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<ClassModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    @PutMapping()
    public ResponseEntity<ClassModel> update(@RequestBody ClassModel model) {
        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");

        return new ResponseEntity<ClassModel>(this.service.update(model), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        ClassModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "A Classe %s foi deletado com sucesso!",
                model.getNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
