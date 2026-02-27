package com.allan_dev.Event.core.entity;

import com.allan_dev.Event.core.enuns.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificadorEvento,
        LocalDateTime inicioEvento,
        LocalDateTime fimEvento,
        String local,
        Integer capacidade,
        TipoEvento tipo,
        String organizador
) {
}
