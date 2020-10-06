package com.java.customerportal.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("giphy")
public class GiphyConfig {
    private String apiToken;
    private String searchRating;
}
