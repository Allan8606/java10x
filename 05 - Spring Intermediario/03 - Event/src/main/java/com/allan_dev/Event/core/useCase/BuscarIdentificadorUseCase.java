package com.allan_dev.Event.core.useCase;

import com.allan_dev.Event.core.entity.Evento;

public interface BuscarIdentificadorUseCase {
    public Evento execute(String identificador);
}
