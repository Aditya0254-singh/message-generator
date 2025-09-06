package com.example.message_generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:3000") // Enables CORS for React frontend
public class MessageController {

    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generateMessage(@RequestBody Map<String, String> request) {
        // Get the "prompt" value from the request JSON
        String prompt = request.get("prompt");

        // Prepare response map
        Map<String, String> response = new HashMap<>();

        if (prompt != null && !prompt.trim().isEmpty()) {
            // Generate message based on the prompt
            response.put("message", "Hello " + prompt + ", Diwali greetings! We wish you the best holiday. Namaste!");
        } else {
            response.put("message", "Hello! Please provide a valid name or prompt.");
        }

        // Return response as JSON
        return ResponseEntity.ok(response);
    }
}


