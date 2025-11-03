package com.labcatp.event_service.Controller;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

public class SimplePayloadEvent extends ApplicationEvent {
    private final Map<String, Object> payload;
    public SimplePayloadEvent(Object source, Map<String, Object> payload) {
        super(source);
        this.payload = payload;
    }
    public Map<String, Object> getPayload() { return payload; }
}
