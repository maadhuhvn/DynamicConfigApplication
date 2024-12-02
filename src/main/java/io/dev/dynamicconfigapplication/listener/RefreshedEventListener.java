package io.dev.dynamicconfigapplication.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RefreshedEventListener {

    @EventListener({RefreshEvent.class})
    public void onRefresh(RefreshEvent event) {
        log.info("^^^^^^^^^^^^^^^^^^");
        log.info("Configuration reloaded: {}", event.getSource());
        log.info("^^^^^^^^^^^^^^^^^^");
    }
}
