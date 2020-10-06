package com.java.customerportal.dto.giphy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyFixedDto extends GiphyFixedWebDto{
    private String mp4;
    private String mp4Size;
}
