package com.allan_dev.Event.infra.mapper;



import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.infra.dto.EventoDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public Evento toEvento(EventoDTO dto){
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificadorEvento(),
                dto.inicioEvento(),
                dto.fimEvento(),
                dto.localEvento(),
                dto.capacidade(),
                dto.tipo(),
                dto.organizador()
        );
    }

    public EventoDTO toEventoDTO(Evento evento){
        return new EventoDTO(
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



}
