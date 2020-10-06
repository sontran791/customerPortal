package com.java.customerportal.service;

import com.java.customerportal.dao.Gif;
import com.java.customerportal.dao.GifTag;
import com.java.customerportal.dao.GifTagLink;
import com.java.customerportal.dao.User;
import com.java.customerportal.dto.gif.GifDto;
import com.java.customerportal.dto.gif.GifTagDto;
import com.java.customerportal.dto.gif.TagRequestDto;
import com.java.customerportal.exception.domain.GifNotFoundException;
import com.java.customerportal.repository.GifRepository;
import com.java.customerportal.repository.GifTagLinkRepository;
import com.java.customerportal.repository.GifTagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class GifService {
    private final ModelMapper modelMapper;
    private final GifRepository gifRepository;
    private final GifTagRepository gifTagRepository;
    private final GifTagLinkRepository gifTagLinkRepository;
    private final UserService userService;

    public void saveTag(String username, GifDto gifDto) {
        Gif gif = modelMapper.map(gifDto, Gif.class);
        User user = userService.findUserByUsername(username);
        gif.setOwnerId(user.getId());
        gifRepository.save(gif);
    }

    public List<GifDto> findAllByUser(String username) {
        User user = userService.findUserByUsername(username);
        return gifRepository.findByOwnerId(user.getId()).stream()
                .map(gif -> modelMapper.map(gif, GifDto.class))
                .collect(Collectors.toList());
    }

    public void tagGif(TagRequestDto tagRequestDto) {
        Gif gif = gifRepository.findById(tagRequestDto.getGifId()).orElseThrow(() -> new GifNotFoundException(tagRequestDto.getGifId()));

        GifTag gifTag = gifTagRepository.findByName(tagRequestDto.getName())
                .orElseGet(() -> gifTagRepository.save(GifTag.builder()
                .name(tagRequestDto.getName())
                .build()));

        GifTagLink gifTagLink = GifTagLink.builder()
                .gif(gif)
                .tag(gifTag)
                .build();

        gifTagLinkRepository.save(gifTagLink);
    }
}
