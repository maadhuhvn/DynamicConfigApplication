package io.dev.dynamicconfigapplication.controller;

import io.dev.dynamicconfigapplication.config.ApplicationConfig;
import io.dev.dynamicconfigapplication.config.DynamicConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/config")
public class ConfigDemoController {

    private final ApplicationConfig applicationConfig;
    private final DynamicConfig dynamicConfig;

    @GetMapping("/info")
    public Map<String, Object> getConfigInfo() {
        Map<String, Object> configInfo = new HashMap<>();
        configInfo.put("lordName", dynamicConfig.getLordName());
        configInfo.put("environment", applicationConfig.getEnvironment());
        configInfo.put("feature", applicationConfig.getFeature());
        configInfo.put("maxConnections", applicationConfig.getMaxConnections());
        return configInfo;
    }
}