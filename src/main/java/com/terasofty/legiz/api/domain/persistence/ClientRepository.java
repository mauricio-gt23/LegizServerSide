package com.terasofty.legiz.api.domain.persistence;

import com.terasofty.legiz.api.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
