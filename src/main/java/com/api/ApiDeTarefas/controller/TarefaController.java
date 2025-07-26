package com.api.ApiDeTarefas.controller;

import com.api.ApiDeTarefas.model.Tarefa;
import com.api.ApiDeTarefas.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/tarefas")
public class    TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tarefa) {
        Tarefa savedTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(savedTarefa);
    }

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }
    @GetMapping("/test")
    public String retorno(){
        return "FUNCIONANDO O ENDPOINT";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetails) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setNome(tarefaDetails.getNome());
            tarefa.setDataEntrega(tarefaDetails.getDataEntrega());
            tarefa.setResponsavel(tarefaDetails.getResponsavel());
            Tarefa updatedTarefa = tarefaRepository.save(tarefa);
            return ResponseEntity.ok(updatedTarefa);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}