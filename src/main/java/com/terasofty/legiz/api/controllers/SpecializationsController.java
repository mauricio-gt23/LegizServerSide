package com.terasofty.legiz.api.controllers;


import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.models.Specialization;
import com.terasofty.legiz.api.domain.service.LawyersService;
import com.terasofty.legiz.api.domain.service.SpecializationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/lawyers/specializations")
@RequiredArgsConstructor
public class SpecializationsController {
    private final SpecializationsService specializationsService;

    @PostMapping
    public ResponseEntity<Specialization> createSpecialization(@Valid @RequestBody Specialization specialization) {
        return ResponseEntity.ok().body(specializationsService.createSpecialization(specialization));
    }

}
