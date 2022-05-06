package com.terasofty.legiz.api.controllers;

import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.service.LawyersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lawyers")
@RequiredArgsConstructor
public class LawyersController {
    private final LawyersService lawyersService;
    @GetMapping
    public ResponseEntity<List<Lawyer>> getLawyers() {
        return ResponseEntity.ok().body(lawyersService.getLawyers());
    }
}
