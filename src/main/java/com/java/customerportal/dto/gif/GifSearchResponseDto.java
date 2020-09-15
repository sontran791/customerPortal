package com.java.customerportal.dto.gif;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GifSearchResponseDto {
    private List<GifDto> gifs;
    private Integer totalCount;
    private Integer count;
    private Integer offset;
}
