package com.allan_dev.Event.core.useCase;

import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
