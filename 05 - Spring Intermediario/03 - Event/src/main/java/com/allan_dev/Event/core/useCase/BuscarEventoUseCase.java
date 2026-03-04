package com.allan_dev.Event.core.useCase;

import com.allan_dev.Event.core.entity.Evento;

import java.util.List;

public interface BuscarEventoUseCase {

    public List<Evento> execute();
}
