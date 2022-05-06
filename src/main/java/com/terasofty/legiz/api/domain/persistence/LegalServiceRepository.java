package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.LegalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalServiceRepository extends JpaRepository<LegalService, Long> {
}
