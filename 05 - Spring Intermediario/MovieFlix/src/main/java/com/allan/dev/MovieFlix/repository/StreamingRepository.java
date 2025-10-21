package com.allan.dev.MovieFlix.repository;

import com.allan.dev.MovieFlix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
