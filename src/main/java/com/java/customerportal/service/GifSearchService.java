package com.java.customerportal.service;

import com.java.customerportal.configuration.GiphyConfig;
import com.java.customerportal.dto.gif.GifSearchResponseDto;
import com.java.customerportal.dto.giphy.GiphySearchResponseDto;
import com.java.customerportal.openFeign.GiphyFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class GifSearchService {
    private final GiphyFeign giphyFeign;
    private final GiphyConfig giphyConfig;
    private final ModelMapper modelMapper;

    public GifSearchResponseDto findGif(String q, Integer limit, Integer offset) {
        GiphySearchResponseDto giphySearchResponseDto = giphyFeign.findGif(giphyConfig.getApiToken(), q, limit, offset, giphyConfig.getSearchRating(), null, null);
        return modelMapper.map(giphySearchResponseDto, GifSearchResponseDto.class);
    }
}
