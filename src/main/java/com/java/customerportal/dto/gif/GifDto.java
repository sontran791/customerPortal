package com.java.customerportal.dto.gif;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class GifDto {
    private Integer gifId;
    private String title;
    private GifVersionDto fixedHeight;
    private GifVersionDto fixedHeightSmallStill;
    private GifVersionDto original;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm-dd-yyyy hh:mm:ss", timezone = "America/Chicago")
    private Date importDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm-dd-yyyy hh:mm:ss", timezone = "America/Chicago")
    private Date trendingDateTime;

    private Set<GifTagDto> tags;
}
