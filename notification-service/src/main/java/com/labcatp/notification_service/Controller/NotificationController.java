package com.labcatp.notification_service.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    @PostMapping("/send")
    public Map<String, Object> send(@RequestBody Map<String, Object> payload) {
        System.out.println("NOTIFY: " + payload);
        return Map.of("status", "SENT", "payload", payload);
    }
}
