package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ClassModel;
import io.github.lgustavogomdam.api_video_locadora.service.ClassService;
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
@RequestMapping("api/class")
@Tag(name = "Classe", description = "Endpoints for managing Classe")
public class ClassAPIController extends AbstractAPIController<ClassModel,Long, ClassService>{

    @Override
    @GetMapping()
    @Operation(summary = "Find all Classes", description = "Find all Classes", tags = {"Class"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassModel.class)))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassModel.class)))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassModel.class)))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassModel.class)))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassModel.class)))})
        })
    public List<ClassModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    @Operation(summary = "Find Class", description = "Find Class", tags = {"Class"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ClassModel.class))}),

            //Response No Content
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ClassModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))})
        })
    public ResponseEntity<ClassModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    @Operation(summary = "Add a new Class", description = "Add new Class by passing in a JSON", tags = {"Class"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ClassModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))})
        })
    public ResponseEntity<ClassModel> create(@RequestBody ClassModel model) {

        if(model.getId() != null)
            model.setId(null);

        return new ResponseEntity<ClassModel>(this.service.create(model),HttpStatus.OK);
    }

    @Override
    @PutMapping()
    @Operation(summary = "Update a Class", description = "Update properties of Class by passing in a JSON", tags = {"Class"},
        responses = {
            //Response Success
            @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ClassModel.class))}),

            //Response No Content
            @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ClassModel.class))}),

            //Response Bad Request
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Unauthorized
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Not Found
            @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))}),

            //Response Internal Error
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ClassModel.class))})
        })
    public ResponseEntity<ClassModel> update(@RequestBody ClassModel model) {
        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");

        return new ResponseEntity<ClassModel>(this.service.update(model), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    @Operation(summary = "Delete a Class", description = "Delete a Class by passing ID in URL", tags = {"Class"},
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
    public ResponseEntity delete(@PathVariable("id") Long id) {
        ClassModel model = this.service.findById(id);
        this.service.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
