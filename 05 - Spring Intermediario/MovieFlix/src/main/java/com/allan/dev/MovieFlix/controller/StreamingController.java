package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.StreamingRequest;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.mapper.StreamingMapper;
import com.allan.dev.MovieFlix.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @PostMapping
    public ResponseEntity<StreamingResponse> createCategory(@Valid @RequestBody StreamingRequest request) {
        Streaming streamService = StreamingMapper.paraStreaming(request);
        Streaming savedStreamService = service.save(streamService);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.paraStreamingResponse(savedStreamService));
    }

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        List<StreamingResponse> services = service.findAll().stream()
                .map(StreamingMapper::paraStreamingResponse)
                .toList();

        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> find(@PathVariable Long id) {
        return service.findById(id)
                .map(streamService -> ResponseEntity.ok(StreamingMapper.paraStreamingResponse(streamService)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
