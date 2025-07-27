package com.api.ApiDeTarefas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tarefa")
    @JsonProperty("tarefa")
    @NotNull(message = "A tarefa é obrigatória")
    @Size(min = 1, max = 100, message = "A tarefa deve ter entre 1 e 100 caracteres")
    private String tarefa;

    @Column(name = "data_entrega")
    @JsonProperty("dataEntrega")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;

    @Column(name = "responsavel")
    @JsonProperty("responsavel")
    @NotNull(message = "O responsável é obrigatório")
    @Size(min = 1, max = 100, message = "O responsável deve ter entre 1 e 100 caracteres")
    private String responsavel;
}