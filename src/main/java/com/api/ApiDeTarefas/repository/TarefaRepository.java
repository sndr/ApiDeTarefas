package com.api.ApiDeTarefas.repository;

import com.api.ApiDeTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}