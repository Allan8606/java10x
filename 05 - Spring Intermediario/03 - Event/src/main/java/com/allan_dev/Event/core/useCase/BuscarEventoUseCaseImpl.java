package com.allan_dev.Event.core.useCase;

import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public List<Evento> execute() {
        return eventoGateway.listarEventos();
    }
}
