package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;
import io.github.lgustavogomdam.api_video_locadora.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/actor")
@Tag(name = "Actor", description = "Endpoints for managing Actor")
public class ActorAPIController extends AbstractAPIController<ActorModel,Long, ActorService>{

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    @GetMapping
    @Operation(summary = "Find all actors", description = "Find all actors", tags = {"Actor"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(mediaType = "application/json",
                        array = @ArraySchema(
                            schema = @Schema(implementation = ActorModel.class)))})
        })
    public List<ActorModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<ActorModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ActorModel> create(@RequestBody ActorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<ActorModel>(this.service.create(model),HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<ActorModel> update(@RequestBody ActorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<ActorModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ActorModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O ator %s %s foi deletado com sucesso!",
                model.getPrimeiroNome().toUpperCase(),
                model.getUltimoNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
