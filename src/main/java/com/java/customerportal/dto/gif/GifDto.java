package com.java.customerportal.dto.gif;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.java.customerportal.configuration.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class GifDto {
    private Integer gifId;
    private String title;
    private GifVersionDto fixedHeight;
    private GifVersionDto fixedHeightSmallStill;
    private GifVersionDto original;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT, timezone = "America/Chicago")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime importDatetime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT, timezone = "America/Chicago")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime trendingDatetime;

    private Set<GifTagDto> tags;
}
