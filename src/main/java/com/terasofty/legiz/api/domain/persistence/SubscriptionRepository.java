package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByName(String name);
}
