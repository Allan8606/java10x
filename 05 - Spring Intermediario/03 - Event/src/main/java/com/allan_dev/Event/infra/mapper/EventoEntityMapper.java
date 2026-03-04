package com.allan_dev.Event.infra.mapper;

import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.infra.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento){
        return new EventoEntity(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificadorEvento(),
                evento.inicioEvento(),
                evento.fimEvento(),
                evento.localEvento(),
                evento.capacidade(),
                evento.tipo(),
                evento.organizador()
        );
    }


    public Evento toDomain(EventoEntity entity){

        return new Evento(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getIdentificadorEvento(),
                entity.getInicioEvento(),
                entity.getFimEvento(),
                entity.getLocalEvento(),
                entity.getCapacidade(),
                entity.getTipo(),
                entity.getOrganizador()
        );
    }

}
