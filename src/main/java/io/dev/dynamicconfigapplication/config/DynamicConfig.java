package io.dev.dynamicconfigapplication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RefreshScope
@Configuration
public class DynamicConfig {

    @Value("${lord.name:Siva}")
    private String lordName;
}
