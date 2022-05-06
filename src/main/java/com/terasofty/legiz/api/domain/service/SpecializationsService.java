package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.Specialization;

import java.util.List;

public interface SpecializationsService {
    List<Specialization> getSpecializations();
    Specialization getSpecialization(String name);
    Specialization createSpecialization(Specialization specialization);
    Specialization updateSpecialization(String name, Specialization specialization);
    void addSpecializationToLawyer(String username, String specializationName);
}
