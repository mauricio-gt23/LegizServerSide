package com.terasofty.legiz.api.domain.service.implementation;

import com.terasofty.legiz.api.domain.models.Lawyer;
import com.terasofty.legiz.api.domain.models.Subscription;
import com.terasofty.legiz.api.domain.persistence.LawyerRepository;
import com.terasofty.legiz.api.domain.persistence.SubscriptionRepository;
import com.terasofty.legiz.api.domain.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final LawyerRepository lawyerRepository;
    @Override
    public Subscription getSubscription(String subscriptionName) {
        return subscriptionRepository.findByName(subscriptionName);
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void addSubscriptionToLawyer(String username, String subscriptionName) {
        Lawyer foundLawyer = lawyerRepository.findByUserUsername(username);
        foundLawyer.setSubscription(getSubscription(subscriptionName));
    }
}
