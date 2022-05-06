package com.terasofty.legiz.api.domain.service.implementation;

import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.models.Specialization;
import com.terasofty.legiz.api.domain.persistence.LawyerRepository;
import com.terasofty.legiz.api.domain.service.LawyersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LawyersServiceImpl implements LawyersService {
    private final LawyerRepository lawyerRepository;
    @Override
    public List<Lawyer> getLawyers() {
        return null;
    }

    @Override
    public Lawyer getLawyer(String username) {
        return lawyerRepository.findByUserUsername(username);
    }

    @Override
    public Lawyer createLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    @Override
    public Lawyer deleteLawyer(Lawyer lawyer) {
        return null;
    }

    @Override
    public void addSpecializationToLawyer(Lawyer lawyer, Specialization specialization) {

    }
}
