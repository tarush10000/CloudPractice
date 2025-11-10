package com.labcatp.transaction_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TransactionController {

        private final RestTemplate rest = new RestTemplate();

        @GetMapping("/transfer")
        public String startTransfer() {
                String debit = rest.postForObject(
                                "http://account-service:8081/account/alice/debit?amount=100",
                                null, String.class);

                String credit = rest.postForObject(
                                "http://account-service:8081/account/bob/credit?amount=100",
                                null, String.class);

                String notify = rest.postForObject(
                                "http://notification-service:8083/notify/send",
                                "Transfer completed from Alice to Bob", String.class);

                return String.format("""
                                Chain completed successfully!
                                %s
                                %s
                                Notification: %s
                                """, debit, credit, notify);
        }
}
