package com.java.customerportal.configuration;

import com.java.customerportal.dao.Gif;
import com.java.customerportal.dao.GifTagLink;
import com.java.customerportal.dto.gif.GifDto;
import com.java.customerportal.dto.gif.GifSearchResponseDto;
import com.java.customerportal.dto.gif.GifTagDto;
import com.java.customerportal.dto.gif.GifVersionDto;
import com.java.customerportal.dto.giphy.GiphyDataDto;
import com.java.customerportal.dto.giphy.GiphySearchResponseDto;
import com.java.customerportal.dto.giphy.GiphyStillDto;
import com.java.customerportal.dto.giphy.GiphyUrlDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(GiphyStillDto.class, GifVersionDto.class)
                .addMapping(GiphyStillDto::getHeight, GifVersionDto::setHeight)
                .addMapping(GiphyStillDto::getWidth, GifVersionDto::setWidth)
                .addMapping(GiphyUrlDto::getUrl, GifVersionDto::setUrl);

        modelMapper.createTypeMap(GiphySearchResponseDto.class, GifSearchResponseDto.class)
                .addMapping(GiphySearchResponseDto::getData, GifSearchResponseDto::setGifs)
                .addMapping(res -> res.getPagination().getTotalCount(), GifSearchResponseDto::setTotalCount)
                .addMapping(res -> res.getPagination().getCount(), GifSearchResponseDto::setCount)
                .addMapping(res -> res.getPagination().getOffset(), GifSearchResponseDto::setOffset);

        modelMapper.createTypeMap(GiphyDataDto.class, GifDto.class)
                .addMapping(data -> data.getImages().getFixedHeight(), GifDto::setFixedHeight)
                .addMapping(data -> data.getImages().getFixedHeightSmallStill(), GifDto::setFixedHeightSmallStill)
                .addMapping(data -> data.getImages().getOriginal(), GifDto::setOriginal);

        modelMapper.createTypeMap(Gif.class, GifDto.class)
                .addMapping(Gif::getTagLinks, GifDto::setTags);

        modelMapper.createTypeMap(GifTagLink.class, GifTagDto.class)
                .addMapping(res -> res.getTag().getName(), GifTagDto::setName)
                .addMapping(res -> res.getTag().getTagId(), GifTagDto::setTagId);

        return modelMapper;
    }
}
