package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.LegalService;

import java.util.List;

public interface LegalServicesService {
    List<LegalService> getLegalServices();
    LegalService getLegalService(Long id);
    LegalService createLegalService(LegalService legalService);
}
