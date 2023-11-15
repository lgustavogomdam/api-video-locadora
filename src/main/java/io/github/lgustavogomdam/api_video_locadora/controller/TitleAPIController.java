package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ActorModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.service.TitleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/title")
public class TitleAPIController extends AbstractAPIController<TitleModel, Long, TitleService> {

    @Override
    @GetMapping
    @Operation(summary = "Find all titles", description = "Find all titles", tags = {"Title"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(
                                                    schema = @Schema(implementation = TitleModel.class)))})})
    public List<TitleModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<TitleModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    public ResponseEntity<TitleModel> create(@RequestBody TitleModel model) {
        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<TitleModel>(this.service.create(model), HttpStatus.CREATED);
    }

    @Override
    @PutMapping()
    public ResponseEntity<TitleModel> update(@RequestBody TitleModel model) {
        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<TitleModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        TitleModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O título %s foi deletado com sucesso!",
                model.getNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
