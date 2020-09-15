package com.java.customerportal.dto.giphy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GiphyImagesDto {
    private GiphyOriginalDto original;
    private GiphyStillDto downsized;
    private GiphyStillDto downsizedLarge;
    private GiphyStillDto downsizedMedium;
    private GiphyStillDto downsizedSmall;
    private GiphyStillDto downsizedStill;
    private GiphyFixedDto fixedHeight;
    private GiphyFixedWebDto fixedHeightDownsampled;
    private GiphyFixedDto fixedHeightSmall;
    private GiphyStillDto fixedHeightSmallStill;
    private GiphyStillDto fixedHeightStill;
    private GiphyFixedDto fixedWidth;
    private GiphyFixedWebDto fixedWidthDownsampled;
    private GiphyFixedDto fixedWidthSmall;
    private GiphyStillDto fixedWidthSmallStill;
    private GiphyStillDto fixedWidthStill;
    private GiphyMP4Dto looping;
    private GiphyStillDto originalStill;
    private GiphyMP4Dto preview;
    private GiphyStillDto previewGif;
}
