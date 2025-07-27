package com.api.ApiDeTarefas.service;

import com.api.ApiDeTarefas.model.Tarefa;
import com.api.ApiDeTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return tarefaRepository.existsById(id);
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    public List<Tarefa> findByResponsavel(String responsavel) {
        return tarefaRepository.findByResponsavel(responsavel);
    }

    public void deleteByResponsavel(String responsavel) {
        tarefaRepository.findByResponsavel(responsavel).forEach(tarefaRepository::delete);
    }
}