package com.terasofty.legiz.api.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api( tags = "Hirings")
@RestController(value = "hirings")
@RequestMapping("/api/hirings")
public class HiringsController {
    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("AAAA");
    }
}
