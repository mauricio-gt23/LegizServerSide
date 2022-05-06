package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.Subscription;

public interface SubscriptionService {
    Subscription getSubscription(String subscriptionName);
    Subscription createSubscription(Subscription subscription);
    void addSubscriptionToLawyer(String username, String subscriptionName);
}
