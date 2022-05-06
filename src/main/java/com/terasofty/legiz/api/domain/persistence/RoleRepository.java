package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
