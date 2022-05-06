package com.terasofty.legiz.api.domain.service;

import com.terasofty.legiz.api.domain.models.Role;
import com.terasofty.legiz.api.domain.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(String username);
    User createUser(User user);
    User deleteUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
