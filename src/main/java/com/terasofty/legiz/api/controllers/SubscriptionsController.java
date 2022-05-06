package com.terasofty.legiz.api.controllers;


import com.terasofty.legiz.api.domain.models.Specialization;
import com.terasofty.legiz.api.domain.service.SpecializationsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/lawyers/subscriptions")
@RequiredArgsConstructor
public class SubscriptionsController {
    private final SpecializationsService specializationsService;

    @PostMapping
    public ResponseEntity<Specialization> createSpecialization(@Valid @RequestBody Specialization specialization) {
        return ResponseEntity.ok().body(specializationsService.createSpecialization(specialization));
    }

    @PostMapping("/assign")
    public ResponseEntity<Map<String, String>> assignSpecialization(@RequestBody AssignForm payload) {
        specializationsService.addSpecializationToLawyer(payload.getUsername(), payload.getSubscription());
        Map<String, String> response = new HashMap<>();
        response.put("response", "Added " + payload.getSubscription() + " to user " + payload.getUsername());
        return ResponseEntity.ok().body(response);
    }
    @Data
    public static class AssignForm {
        String subscription;
        String username;
    }
}
