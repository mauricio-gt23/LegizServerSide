package com.terasofty.legiz.db;

import com.terasofty.legiz.api.domain.models.*;
import com.terasofty.legiz.api.domain.service.LawyersService;
import com.terasofty.legiz.api.domain.service.SpecializationsService;
import com.terasofty.legiz.api.domain.service.SubscriptionService;
import com.terasofty.legiz.api.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class DataSeed implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    SpecializationsService specializationsService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    LawyersService lawyersService;

    @Override
    public void run(String... args) throws Exception {
        if (!Objects.equals(System.getenv("SPRING_ENV"), "prod")) {
            createRoles();
            createUsers();
            createSpecializations();
            createSubscriptions();
            createLawyers();
        }
    }
    private void createRoles() {
        userService.saveRole(new Role(null, "ROLE_CLIENT"));
        userService.saveRole(new Role(null, "ROLE_LAWYER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
    }
    private void createUsers() {
        userService.createUser(new User(null, "John", "Smith", "john", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Tony", "Green", "tony", "12345", new ArrayList<>()));
        userService.createUser(new User(null, "Alessandro", "Chumpitaz", "hyper", "12345", new ArrayList<>()));

        userService.addRoleToUser("hyper", "ROLE_ADMIN");
        userService.addRoleToUser("john", "ROLE_LAWYER");
        userService.addRoleToUser("tony", "ROLE_LAWYER");
    }
    private void createSpecializations() {
        specializationsService.createSpecialization(new Specialization(null, "Criminal"));
        specializationsService.createSpecialization(new Specialization(null, "Business"));
        specializationsService.createSpecialization(new Specialization(null, "Family"));
        specializationsService.createSpecialization(new Specialization(null, "International"));
    }
    private void createSubscriptions() {
        subscriptionService.createSubscription(new Subscription(null, "MEMBER", 39.99, ""));
    }
    private void createLawyers() {
        lawyersService.createLawyer(
                new Lawyer(
                        null,
                        userService.getUser("john"),
                        new ArrayList<>(),
                        new Subscription()
                        ));
        subscriptionService.addSubscriptionToLawyer("john", "MEMBER");
    }
}
