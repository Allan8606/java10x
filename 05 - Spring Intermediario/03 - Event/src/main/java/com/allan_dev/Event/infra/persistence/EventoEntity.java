package com.allan_dev.Event.infra.persistence;


import com.allan_dev.Event.core.enuns.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String identificadorEvento;
    private LocalDateTime inicioEvento;
    private LocalDateTime fimEvento;
    private String local;
    private Integer capacidade;
    private TipoEvento tipo;
    private String organizador;

}
