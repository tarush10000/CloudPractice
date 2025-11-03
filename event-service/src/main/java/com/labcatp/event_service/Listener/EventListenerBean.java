package com.labcatp.event_service.Listener;

import com.labcatp.event_service.Controller.SimplePayloadEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerBean {
    @EventListener
    public void on(SimplePayloadEvent ev) {
        System.out.println("Received event: " + ev.getPayload());
    }
}
