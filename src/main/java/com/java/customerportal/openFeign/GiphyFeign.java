package com.java.customerportal.openFeign;

import com.java.customerportal.dto.giphy.GiphySearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy", url = "api.giphy.com")
@RequestMapping("/v1/gifs/search")
public interface GiphyFeign {
    @GetMapping
    GiphySearchResponseDto findGif(
            @RequestParam String api_key,
            @RequestParam String q,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) String rating,
            @RequestParam(required = false) String lang,
            @RequestParam(required = false) String random_id
    );
}
