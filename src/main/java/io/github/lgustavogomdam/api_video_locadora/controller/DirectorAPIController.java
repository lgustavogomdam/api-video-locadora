package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.DirectorModel;
import io.github.lgustavogomdam.api_video_locadora.service.DirectorService;
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

@RestController
@RequestMapping("api/director")
@Tag(name = "Director", description = "Endpoints for managing Director")
public class DirectorAPIController extends AbstractAPIController<DirectorModel,Long, DirectorService>{

    @Override
    @GetMapping()
    @Operation(summary = "Find all Directors", description = "Find all Directors", tags = {"Director"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectorModel.class)))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectorModel.class)))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectorModel.class)))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectorModel.class)))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DirectorModel.class)))})
            })
    public List<DirectorModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    @Operation(summary = "Find Director", description = "Find Director", tags = {"Director"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DirectorModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))})
            })
    public ResponseEntity<DirectorModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    @Operation(summary = "Add a new Director", description = "Add new Director by passing in a JSON", tags = {"Director"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))})
            })
    public ResponseEntity<DirectorModel> create(@RequestBody DirectorModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<DirectorModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    @PutMapping()
    @Operation(summary = "Update a Director", description = "Update properties of Director by passing in a JSON", tags = {"Director"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DirectorModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DirectorModel.class))})
            })
    public ResponseEntity<DirectorModel> update(@RequestBody DirectorModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");
        
        return new ResponseEntity<DirectorModel>(this.service.update(model),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    @Operation(summary = "Delete a Director", description = "Delete a director by passing ID in URL", tags = {"Director"},
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
