package com.terasofty.legiz.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomCase {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull @NotBlank
    private String description;
}
