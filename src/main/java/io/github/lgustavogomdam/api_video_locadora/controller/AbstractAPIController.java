package io.github.lgustavogomdam.api_video_locadora.controller;

import io.github.lgustavogomdam.api_video_locadora.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractAPIController<M,K,S extends AbstractService>{

    @Autowired
    protected S service;

    @GetMapping()
    public List<M> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<M> findById(@PathVariable K id){
        return new ResponseEntity<M>((M) this.service.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<M> create(@RequestBody(required = true) M model){
        return new ResponseEntity<M>((M) this.service.create(model),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<M> update(@RequestBody(required = true) M model){
        return new ResponseEntity<M>((M) this.service.update(model),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable K id){
        this.service.softDelete(id);
        M model = (M) this.service.findById(id);
        return new ResponseEntity<String>(String.format(
                "O elemento foi deletado com sucesso!"
        ), HttpStatus.OK);
    }
}
