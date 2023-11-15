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
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActorModel.class)))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActorModel.class)))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActorModel.class)))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActorModel.class)))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActorModel.class)))})
        })
    public List<ActorModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    @Operation(summary = "Find actor", description = "Find actor", tags = {"Actor"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ActorModel.class))}),

            //Response No Content
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ActorModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))})
        })
    public ResponseEntity<ActorModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    @Operation(summary = "Add a new actor", description = "Add new actor by passing in a JSON", tags = {"Actor"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ActorModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))})
        })
    public ResponseEntity<ActorModel> create(@RequestBody ActorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<ActorModel>(this.service.create(model),HttpStatus.CREATED);
    }

    @Override
    @PutMapping()
    @Operation(summary = "Update a actor", description = "Update properties of actor by passing in a JSON", tags = {"Actor"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ActorModel.class))}),

            //Response No Content
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ActorModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ActorModel.class))})
        })
    public ResponseEntity<ActorModel> update(@RequestBody ActorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<ActorModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("{id}")
    @Operation(summary = "Delete a actor", description = "Delete a actor by passing ID in URL", tags = {"Actor"},
        responses = {
            //Response No Content
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json")}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json")}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json")}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json")}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json")})
        })
    public ResponseEntity delete(@PathVariable Long id) {
        ActorModel model = this.service.findById(id);
        this.service.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
