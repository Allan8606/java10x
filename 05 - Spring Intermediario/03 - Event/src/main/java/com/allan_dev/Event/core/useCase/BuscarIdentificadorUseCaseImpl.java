package com.allan_dev.Event.core.useCase;

import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.core.gateway.EventoGateway;
import com.allan_dev.Event.infra.exceptions.EventNotFound;

public class BuscarIdentificadorUseCaseImpl implements BuscarIdentificadorUseCase{

    private final EventoGateway eventoGateway;

    public BuscarIdentificadorUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarEventoPorIdentificador(identificador);
    }
}
