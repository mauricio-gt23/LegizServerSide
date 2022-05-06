package com.terasofty.legiz.api.domain.service.implementation;

import com.terasofty.legiz.api.domain.models.Specialization;
import com.terasofty.legiz.api.domain.persistence.SpecializationRepository;
import com.terasofty.legiz.api.domain.service.SpecializationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecializationsServiceImpl implements SpecializationsService {
    private final SpecializationRepository specializationRepository;
    @Override
    public List<Specialization> getSpecializations() {
        return specializationRepository.findAll();
    }
    @Override
    public Specialization getSpecialization(String name) {
        return specializationRepository.findByName(name);
    }

    @Override
    public Specialization createSpecialization(Specialization specialization) {
        log.info("Saving new specialization {} to the database", specialization.getName());
        return specializationRepository.save(specialization);

    }

    @Override
    public Specialization updateSpecialization(String name, Specialization specialization) {
        return null;
    }

    @Override
    public void addSpecializationToLawyer(String username, String specializationName) {
        log.info("Adding {} to user {}", specializationName, username);
    }
}
