package com.java.customerportal.dto.giphy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphySearchResponseDto {
    private List<GiphyDataDto> data;
    private GiphyPaginationDto pagination;
    private GiphyMetaDto meta;
}
