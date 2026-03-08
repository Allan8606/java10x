package com.allan_dev.Event.infra.beans;


import com.allan_dev.Event.core.gateway.EventoGateway;
import com.allan_dev.Event.core.useCase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoUseCase buscarEventos(EventoGateway eventoGateway){
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarIdentificadorUseCase buscarIdentificador(EventoGateway eventoGateway){
        return new BuscarIdentificadorUseCaseImpl(eventoGateway);
    }



}
