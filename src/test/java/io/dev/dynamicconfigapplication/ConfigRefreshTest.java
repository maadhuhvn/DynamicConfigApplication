package io.dev.dynamicconfigapplication;

import io.dev.dynamicconfigapplication.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ConfigRefreshTest {
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private ConfigurableEnvironment environment;
    @Qualifier("configDataContextRefresher")
    @Autowired
    private ContextRefresher contextRefresher;

    @Test
    public void testConfigurationRefresh() {
        // Initial configuration
        assertEquals("development", applicationConfig.getEnvironment());
        assertEquals(100, applicationConfig.getMaxConnections());
        // Simulate configuration change
        Map<String, Object> newProperties = new HashMap<>();
        newProperties.put("app.environment", "staging");
        newProperties.put("app.max-connections", 200);
        // Add new property source
        environment.getPropertySources().addFirst(
                new MapPropertySource("testProperties", newProperties)
        );
        // Refresh context
        contextRefresher.refresh();
        // Verify updated configuration
        assertEquals("staging", applicationConfig.getEnvironment());
        assertEquals(200, applicationConfig.getMaxConnections());
    }
}

