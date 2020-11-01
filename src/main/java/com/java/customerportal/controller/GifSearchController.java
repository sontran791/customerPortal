package com.java.customerportal.controller;

import com.java.customerportal.dto.gif.GifSearchResponseDto;
import com.java.customerportal.exception.domain.ExceptionHandling;
import com.java.customerportal.service.GifSearchService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gif-search")
@Api(tags = "Giphy Search Endpoint", value = "Controller for Giphy Search Service")
public class GifSearchController extends ExceptionHandling {
    private final GifSearchService gifSearchService;

    @GetMapping
    public GifSearchResponseDto findGif(@RequestParam String q,
                                          @RequestParam(required = false) Integer limit,
                                          @RequestParam(required = false) Integer offset) {
        return gifSearchService.findGif(q, limit, offset);
    }
}
