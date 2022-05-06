package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.User;
import com.terasofty.legiz.api.domain.persistence.UserRepository;
import com.terasofty.legiz.api.domain.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    private User user, user2;
    @InjectMocks
    private UserServiceImpl userService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "Alessandro", "Chumpitaz", "hyper", "12345", new ArrayList<>());
        user2 = new User(2L, "John", "Smith", "john", "12345", new ArrayList<>());
    }
    @Test
    void getUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user, user2));
        List<User> users = userService.getUsers();
        assertNotNull(users);
        assertEquals(users.size(), 2);
    }
    @Test
    void saveUser() {
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User new_user = userService.createUser(user);
        assertNotNull(new_user);
        assertEquals(new_user.getUsername(), "hyper");
    }
    @Test
    void getUser() {
        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
        User found_user = userService.getUser("hyper");
        assertNotNull(found_user);
        assertEquals(found_user.getUsername(), "hyper");
    }
}