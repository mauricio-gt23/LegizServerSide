package com.terasofty.legiz.api.domain.models;

import com.terasofty.legiz.api.domain.enumerable.LegalServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalService {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull @NotBlank
    private LegalServiceStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "lawyer_id", nullable = false)
    private Lawyer lawyer;

    @Nullable
    @ManyToOne
    private CustomCase customCase;

    @Nullable
    @ManyToOne
    private Advice advice;

    @OneToMany
    private Collection<Document> documents;
}
