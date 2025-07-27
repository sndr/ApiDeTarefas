package com.api.ApiDeTarefas.controller;

import com.api.ApiDeTarefas.model.Tarefa;
import com.api.ApiDeTarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa) {
        Tarefa tarefaSalva = tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.ok(tarefaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTarefas() {
        List<Tarefa> tarefas = tarefaService.findAll();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("FUNCIONANDO O ENDPOINT");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.findById(id);
        return tarefa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaDetails) {
        Optional<Tarefa> tarefaOptional = tarefaService.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setNome(tarefaDetails.getNome());
            tarefa.setDataEntrega(tarefaDetails.getDataEntrega());
            tarefa.setResponsavel(tarefaDetails.getResponsavel());
            Tarefa updatedTarefa = tarefaService.salvarTarefa(tarefa);
            return ResponseEntity.ok(updatedTarefa);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        if (tarefaService.existsById(id)) {
            tarefaService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}