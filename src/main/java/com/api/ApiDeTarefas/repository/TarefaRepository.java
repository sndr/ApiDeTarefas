package com.api.ApiDeTarefas.repository;

import com.api.ApiDeTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByResponsavel(String responsavel);
}