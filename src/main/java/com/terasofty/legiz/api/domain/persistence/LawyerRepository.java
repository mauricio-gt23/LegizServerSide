package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    Lawyer findByUserUsername (String username);
    Lawyer findByUser (User user);
}
