package com.terasofty.legiz.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
public class HomeController {
    @GetMapping
    public Map<String, String> greet() {
        Map<String, String> response = new HashMap<>();
        response.put("response", "Welcome to Legiz API");
        return response;
    }
}
