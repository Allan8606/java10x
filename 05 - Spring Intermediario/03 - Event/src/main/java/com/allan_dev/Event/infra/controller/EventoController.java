package com.allan_dev.Event.infra.controller;


import com.allan_dev.Event.core.entity.Evento;
import com.allan_dev.Event.core.useCase.BuscarEventoUseCase;
import com.allan_dev.Event.core.useCase.CriarEventoUseCase;
import com.allan_dev.Event.infra.dto.EventoDTO;
import com.allan_dev.Event.infra.mapper.EventoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final EventoMapper eventoMapper;

    //Construtor
    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoMapper eventoMapper, BuscarEventoUseCase buscarEventoUseCase) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoMapper = eventoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
    }

    @PostMapping("/criarEvento")
    public ResponseEntity<Map<String, Object>>  criarEventio(@RequestBody EventoDTO eventoDTO){
        Evento novoEvento = criarEventoUseCase.execute(eventoMapper.toEvento(eventoDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("Menssagem: ", "Evento criado com sucesso");
        response.put("Dados do Evento: ", eventoMapper.toEventoDTO(novoEvento));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);



    }


    @GetMapping("/listarEventos")
    public List<EventoDTO> listarEventos(){
      return   buscarEventoUseCase.execute()
                .stream()
                .map(evento -> eventoMapper.toEventoDTO(evento))
                .toList();

    }


}
