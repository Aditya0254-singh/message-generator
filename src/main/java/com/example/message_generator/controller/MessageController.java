package com.example.message_generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "https://message-generator-frontend-ge65.onrender.com")
public class MessageController {

    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generateMessage(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        Map<String, String> response = new HashMap<>();

        if (prompt != null && !prompt.trim().isEmpty()) {
            response.put("message", "Hello " + prompt + ", Diwali greetings! We wish you the best holiday. Namaste!");
        } else {
            response.put("message", "Hello! Please provide a valid name or prompt.");
        }
        return ResponseEntity.ok(response);
    }
}



