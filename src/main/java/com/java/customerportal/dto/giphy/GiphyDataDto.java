package com.java.customerportal.dto.giphy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.java.customerportal.configuration.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyDataDto {
    private String type;
    private String id;
    private String url;
    private String slug;
    private String bitlyUrl;
    private String bitlyGifUrl;
    private String embedUrl;
    private String username;
    private String source;
    private String title;
    private String rating;
    private String contentUrl;
    private String sourceTld;
    private String sourcePostUrl;
    private Boolean isSticker;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT, timezone = "America/Chicago")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime importDatetime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = LocalDateTimeDeserializer.GIPHY_DATETIME_FORMAT, timezone = "America/Chicago")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime trendingDatetime;

    private GiphyImagesDto images;
    private GiphyAnalyticsDto analytics;
}
