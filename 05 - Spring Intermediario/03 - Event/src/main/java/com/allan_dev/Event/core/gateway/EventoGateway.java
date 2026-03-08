package com.allan_dev.Event.core.gateway;

import com.allan_dev.Event.core.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {
    Evento criarEvento(Evento evento);

    List<Evento> listarEventos();

    Evento buscarEventoPorIdentificador(String identificador);




}


