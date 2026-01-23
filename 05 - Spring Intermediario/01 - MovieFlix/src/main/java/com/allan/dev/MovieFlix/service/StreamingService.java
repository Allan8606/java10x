package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.controller.request.StreamingRequest;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.mapper.StreamingMapper;
import com.allan.dev.MovieFlix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public Streaming save(Streaming streamService) {
        return streamingRepository.save(streamService);
    }

    public Optional<Streaming> findById(Long id) {
        return streamingRepository.findById(id);
    }

    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    public void deleteById(Long id) {
        streamingRepository.deleteById(id);
    }

}
