package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
