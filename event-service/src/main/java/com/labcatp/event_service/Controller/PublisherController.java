package com.labcatp.event_service.Controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class PublisherController {
    private final ApplicationEventPublisher publisher;
    public PublisherController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Map<String, Object> payload) {
        publisher.publishEvent(new SimplePayloadEvent(this, payload));
        return "PUBLISHED";
    }
}
