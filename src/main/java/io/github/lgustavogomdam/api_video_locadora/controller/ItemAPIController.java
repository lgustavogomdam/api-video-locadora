package io.github.lgustavogomdam.api_video_locadora.controller;


import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.service.ItemService;
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
@RequestMapping("api/item")
@Tag(name = "Item", description = "Endpoints for managing Item")
public class ItemAPIController extends AbstractAPIController<ItemModel,Long, ItemService> {

    @Override
    @GetMapping()
    @Operation(summary = "Find all Item", description = "Find all Item", tags = {"Item"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItemModel.class)))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItemModel.class)))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItemModel.class)))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItemModel.class)))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ItemModel.class)))})
            })
    public List<ItemModel> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("{id}")
    @Operation(summary = "Find Item", description = "Find Item", tags = {"Item"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ItemModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ItemModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))})
            })
    public ResponseEntity<ItemModel> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @PostMapping()
    @Operation(summary = "Add a new Item", description = "Add new Item by passing in a JSON", tags = {"Item"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ItemModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))})
            })
    public ResponseEntity<ItemModel> create(@RequestBody ItemModel model) {

        if(model.getId() != null)
            model.setId(null);

        System.out.println("====================================Item:\n" +
                "Numero serie: " + model.getNumero_de_serie() + "\n" +
                "Data: " + model.getData_aquisicao() + "\n" +
                "Tipo: " + model.getTipo_item() + "\n" +
                "Titulo ID: " + model.getTitulo().getId() + "\n" +
                "Titulo nome: " + model.getTitulo().getNome() + "\n" +
                "Titulo Cat: " + model.getTitulo().getCategoria() + "\n" +
                "Titulo Sinopse: " + model.getTitulo().getSinopse() + "\n" +
                "Titulo Ano: " + model.getTitulo().getAno() + "\n" +
                "Titulo ator: " + model.getTitulo().getActor().getId() + "\n" +
                "Titulo diretor: " + model.getTitulo().getDirector().getId() + "\n" +
                "Titulo classe: " + model.getTitulo().getClasse().getId() + "\n"
        );
        return new ResponseEntity<ItemModel>(this.service.create(model), HttpStatus.CREATED);
    }

    @Override
    @PutMapping()
    @Operation(summary = "Update a Item", description = "Update properties of Item by passing in a JSON", tags = {"Item"},
            responses = {
                    //Response Success
                    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ItemModel.class))}),

                    //Response No Content
                    @ApiResponse(description = "No Content", responseCode = "204", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ItemModel.class))}),

                    //Response Bad Request
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Unauthorized
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Not Found
                    @ApiResponse(description = "Not Found", responseCode = "404", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))}),

                    //Response Internal Error
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemModel.class))})
            })
    public ResponseEntity<ItemModel> update(@RequestBody ItemModel model) {

        if (model.getId() == null)
            throw new RuntimeException("O ID do elemento não pode ser NULL");

        return new ResponseEntity<ItemModel>(this.service.update(model), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("{id}")
    @Operation(summary = "Delete a Item", description = "Delete a Item by passing ID in URL", tags = {"Item"},
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
        ItemModel model = this.service.findById(id);
        this.service.softDelete(id);
        return new ResponseEntity<String>(String.format(
                "O Item %s foi deletado com sucesso!",
                model.getNumero_de_serie().toString().toUpperCase()
        ),HttpStatus.OK);
    }
}
