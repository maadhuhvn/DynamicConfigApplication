package io.dev.dynamicconfigapplication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {
    private String environment;
    private String feature;
    private int maxConnections;
}