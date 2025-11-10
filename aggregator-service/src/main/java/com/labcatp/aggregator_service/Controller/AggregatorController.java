package com.labcatp.aggregator_service.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/agg")
public class AggregatorController {

    private final RestTemplate rest = new RestTemplate();

    // Use Docker service name if PEER_ACCOUNT is set; fall back to localhost for IDE runs
    private static final String ACCOUNT_BASE =
            System.getenv().getOrDefault("PEER_ACCOUNT", "http://account-service:8081");

    @GetMapping("/dashboard/{id}")
    public String dashboard(@PathVariable String id) {
        String balance = rest.getForObject(ACCOUNT_BASE + "/account/" + id + "/balance", String.class);

        return String.format("""
                Dashboard
                Account: %s
                %s
                """, id, balance);
    }
}
