package com.terasofty.legiz.api.domain.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users", schema = "public")
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    @Size(min = 5, max = 30)
    private String firstName;

    @Size(min = 5, max = 30)
    private  String lastName;

    @NotNull @NotBlank
    @Column(unique = true)
    private String username;

    @NotNull @NotBlank
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
