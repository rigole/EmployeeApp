package com.plass.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.plass.webapp")
public class CustomProperties {

    private String apiUrl;
}
