package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.StreamingRequest;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.mapper.StreamingMapper;
import com.allan.dev.MovieFlix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> listarTodas(){
        List<Streaming> listaStreaming = streamingService.listarTodos();
        List<StreamingResponse> lista = listaStreaming.stream()
                .map(StreamingMapper::paraStreamingResponse)
                .toList();

        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> buscarPorId(@PathVariable Long id){
        return streamingService.buscarPorId(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.paraStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());


    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> salvarStreaming(@RequestBody StreamingRequest request){
        Streaming novaStreaming = StreamingMapper.paraStreaming(request);

        Streaming salvarStreaming = streamingService.salvar(novaStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.paraStreamingResponse(salvarStreaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        streamingService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> atualizar(@PathVariable Long id, @RequestBody StreamingRequest request){
        return streamingService.atualizar(id, request)
                .map(streamingResponse -> ResponseEntity.ok(streamingResponse))
                .orElse(ResponseEntity.notFound().build());
    }



}
