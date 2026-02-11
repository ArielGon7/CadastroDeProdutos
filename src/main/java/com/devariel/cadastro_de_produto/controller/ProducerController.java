package com.devariel.cadastro_de_produto.controller;

import com.devariel.cadastro_de_produto.exception.ResourceNotFoundException;
import com.devariel.cadastro_de_produto.model.Producer;
import com.devariel.cadastro_de_produto.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
    public final ProducerService producerService;

    @GetMapping
    public ResponseEntity<List<Producer>> findAll(){
        return ResponseEntity.ok(producerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
            Producer producer = producerService.findById(id);
            return ResponseEntity.ok(producer);
    }

    @PostMapping
    public ResponseEntity<Producer> save(@RequestBody Producer producer){
        return ResponseEntity.status(HttpStatus.CREATED).body(producerService.save(producer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        producerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producer> update(@RequestBody Producer producer, @PathVariable Long id){
        return ResponseEntity.ok(producerService.update(producer, id));
    }
}
