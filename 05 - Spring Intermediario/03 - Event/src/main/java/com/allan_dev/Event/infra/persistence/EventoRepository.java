package com.allan_dev.Event.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    boolean existsByIdentificadorEvento(String identificadorEvento);

    //boolean existeEventoComIdentificador(String identificador);

    Optional<EventoEntity> findByIdentificadorEvento(String identificador);
}
