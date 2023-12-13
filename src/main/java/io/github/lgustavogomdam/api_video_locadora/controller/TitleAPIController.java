package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.*;
import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
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
@CrossOrigin(origins = "http://localhost:4200")
public class TitleAPIController extends AbstractAPIController<TitleModel, Long, TitleService> {

    @Override
    @GetMapping()
    @Operation(summary = "Find all Titles", description = "Find all Titles", tags = {"Title"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TitleModel.class)))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TitleModel.class)))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TitleModel.class)))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TitleModel.class)))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TitleModel.class)))})
            })
    public List<TitleModel> findAll() {
        return super.findAll();
    }

    @GetMapping("/findTitles/{searchTerm}")
    @Operation(summary = "Find Titles", description = "Find Titles by name", tags = {"Title"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))})
            })
    public List<TitleModel> findByName(@PathVariable String searchTerm) {
        return this.service.findByName(searchTerm);
    }

    @Override
    @GetMapping("{id}")
    @Operation(summary = "Find Title", description = "Find Title", tags = {"Title"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))})
            })
    public ResponseEntity<TitleModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    @Operation(summary = "Add a new Title", description = "Add new Title by passing in a JSON", tags = {"Title"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))})
            })
    public ResponseEntity<TitleModel> create(@RequestBody TitleModel model) {
        System.out.println(model.getId());


        return new ResponseEntity<TitleModel>(this.service.create(model), HttpStatus.CREATED);
    }

    @Override
    @PutMapping()
    @Operation(summary = "Update a Title", description = "Update properties of Title by passing in a JSON", tags = {"Title"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = TitleModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TitleModel.class))})
            })
    public ResponseEntity<TitleModel> update(@RequestBody TitleModel model) {

        return new ResponseEntity<TitleModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("{id}")
    @Operation(summary = "Delete a Title", description = "Delete a Title by passing ID in URL", tags = {"Title"},
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
        TitleModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O título %s foi deletado com sucesso!",
                model.getNome().toUpperCase()
        ),HttpStatus.OK);
    }
}
