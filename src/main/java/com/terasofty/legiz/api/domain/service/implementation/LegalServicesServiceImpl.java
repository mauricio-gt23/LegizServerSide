package com.terasofty.legiz.api.domain.service.implementation;

import com.terasofty.legiz.api.domain.models.LegalService;
import com.terasofty.legiz.api.domain.persistence.LegalServiceRepository;
import com.terasofty.legiz.api.domain.service.LegalServicesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LegalServicesServiceImpl implements LegalServicesService {
    private final LegalServiceRepository legalServiceRepository;
    @Override
    public List<LegalService> getLegalServices() {
        return legalServiceRepository.findAll();
    }

    @Override
    public LegalService getLegalService(Long id) {
        return legalServiceRepository.getById(id);
    }

    @Override
    public LegalService createLegalService(LegalService legalService) {
        return legalServiceRepository.save(legalService);
    }
}
