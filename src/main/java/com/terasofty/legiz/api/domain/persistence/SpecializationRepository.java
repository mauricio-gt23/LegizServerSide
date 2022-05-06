package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    Specialization findByName(String name);
}
