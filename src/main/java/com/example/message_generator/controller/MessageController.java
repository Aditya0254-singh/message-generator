package com.example.message_generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "https://message-generator-qhye.onrender.com")
public class MessageController {
    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generateMessage(@RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        if (name != null && !name.trim().isEmpty()) {
            response.put("message", "Hello " + name + ", Diwali greetings! We wish you the best holiday. Namaste!");
        } else {
            response.put("message", "Hello! Please provide a valid name or prompt.");
        }
        return ResponseEntity.ok(response);
    }
}



