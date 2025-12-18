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

    public List<Streaming> listarTodos(){
        return streamingRepository.findAll();
    }

    public Streaming salvar(Streaming streaming){
        return streamingRepository.save(streaming);
    }


    public Optional<Streaming> buscarPorId(Long id){
        return streamingRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        if (streamingRepository.existsById(id)) {
            streamingRepository.deleteById(id);
        }
    }

    public Optional<StreamingResponse> atualizar(Long id, StreamingRequest request){
        return streamingRepository.findById(id)
                .map(s -> {
                    s.setName(request.name());
                    streamingRepository.save(s);
                    return StreamingMapper.paraStreamingResponse(s);
                });
    }

}
