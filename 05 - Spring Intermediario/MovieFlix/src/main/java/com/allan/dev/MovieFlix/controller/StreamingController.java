package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.StreamingRequest;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.mapper.StreamingMapper;
import com.allan.dev.MovieFlix.service.StreamingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Streaming", description = "Recurso responsável pelo gerenciamento dos streaming dos filmes")
public class StreamingController {

    private final StreamingService service;


    @Operation(
            summary = "Cria um novo streaming",
            description = "Método responsável por criar/ccadastrar um novo streaming",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "201",
            description = "Streaming criado com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class))
    )
    @PostMapping
    public ResponseEntity<StreamingResponse> createStreaming(@Valid @RequestBody StreamingRequest request) {
        Streaming streamService = StreamingMapper.paraStreaming(request);
        Streaming savedStreamService = service.save(streamService);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.paraStreamingResponse(savedStreamService));
    }


    @Operation(
            summary = "Lista todos os streaming cadastrados",
            description = "Método responsável por listar todos os streaming cadastrados",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista todos os streaming cadastrados",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class)))
    )
    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        List<StreamingResponse> services = service.findAll().stream()
                .map(StreamingMapper::paraStreamingResponse)
                .toList();

        return ResponseEntity.ok(services);
    }

    @Operation(
            summary = "Busca por ID do streaming",
            description = "Método responsável por buscar streaming pelo seu ID",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(responseCode = "200", description = "Streaming encontrado com sucesso",
    content = @Content(schema = @Schema(implementation = StreamingResponse.class))
    )
    @ApiResponse(responseCode = "404", description = "Streaming não encontrado", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(streamService -> ResponseEntity.ok(StreamingMapper.paraStreamingResponse(streamService)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Deleta streaming",
            description = "Método responsável por deletar um streaming cadastrado",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponse(
            responseCode = "200",
            description = "Streaming deletado com sucesso",
            content = @Content()
    )
    @ApiResponse(
            responseCode = "404",
            description = "Streaming não encontrado",
            content = @Content()
    )
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
