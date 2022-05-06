package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.models.Specialization;

import java.util.List;

public interface LawyersService {
    List<Lawyer> getLawyers();
    Lawyer getLawyer(String username);
    Lawyer createLawyer(Lawyer lawyer);
    Lawyer deleteLawyer(Lawyer lawyer);
    void addSpecializationToLawyer(Lawyer lawyer, Specialization specialization);
}
