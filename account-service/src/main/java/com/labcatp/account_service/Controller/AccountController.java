package com.labcatp.account_service.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final Map<String, Integer> accounts = new HashMap<>();

    public AccountController() {
        accounts.put("alice", 1000);
        accounts.put("bob", 500);
    }

    @GetMapping("/{id}/balance")
    public String getBalance(@PathVariable String id) {
        int balance = accounts.getOrDefault(id, 0);
        return String.format("Account: %s | Balance: %d", id, balance);
    }

    @PostMapping("/{id}/debit")
    public String debit(@PathVariable String id, @RequestParam int amount) {
        int balance = accounts.getOrDefault(id, 0);
        if (balance < amount) {
            return String.format("Account: %s | Error: Insufficient funds", id);
        }
        accounts.put(id, balance - amount);
        return String.format("Account: %s | Debited: %d | New Balance: %d", id, amount, accounts.get(id));
    }

    @PostMapping("/{id}/credit")
    public String credit(@PathVariable String id, @RequestParam int amount) {
        accounts.put(id, accounts.getOrDefault(id, 0) + amount);
        return String.format("Account: %s | Credited: %d | New Balance: %d", id, amount, accounts.get(id));
    }
}
