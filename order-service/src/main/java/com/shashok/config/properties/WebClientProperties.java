package com.shashok.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "client.inventory-service")
public class WebClientProperties {
    private String baseUrl;
}
