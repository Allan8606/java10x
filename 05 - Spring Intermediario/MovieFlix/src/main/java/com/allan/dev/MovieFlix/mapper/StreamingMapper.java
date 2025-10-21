package com.allan.dev.MovieFlix.mapper;

import com.allan.dev.MovieFlix.controller.request.StreamingRequest;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming paraStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse paraStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }





}
