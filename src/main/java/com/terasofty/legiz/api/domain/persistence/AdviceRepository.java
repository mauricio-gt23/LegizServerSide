package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
