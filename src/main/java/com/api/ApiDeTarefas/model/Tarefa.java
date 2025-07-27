package com.api.ApiDeTarefas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @JsonProperty("nome")
    @NotNull(message = "O nome da tarefa é obrigatório")
    @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
    private String nome;

    @Column(name = "data_entrega")
    @JsonProperty("dataEntrega")
    private LocalDate dataEntrega;

    @Column(name = "responsavel")
    @JsonProperty("responsavel")
    @NotNull(message = "O responsável é obrigatório")
    @Size(min = 1, max = 100, message = "O responsável deve ter entre 1 e 100 caracteres")
    private String responsavel;
}