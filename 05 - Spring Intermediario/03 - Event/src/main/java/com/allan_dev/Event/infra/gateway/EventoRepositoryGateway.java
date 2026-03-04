package com.allan_dev.Event.infra.gateway;

import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.core.gateway.EventoGateway;
import com.allan_dev.Event.infra.mapper.EventoEntityMapper;
import com.allan_dev.Event.infra.persistence.EventoEntity;
import com.allan_dev.Event.infra.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper eventoEntityMapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoEntityMapper = eventoEntityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = eventoEntityMapper.toEntity(evento);
        EventoEntity save = eventoRepository.save(entity);

        return eventoEntityMapper.toDomain(save);
    }

    @Override
    public List<Evento> listarEventos() {
       return eventoRepository.findAll()
                .stream()
                .map(evento -> eventoEntityMapper.toDomain(evento))
                .toList();
    }


}

