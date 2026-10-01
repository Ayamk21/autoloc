package com.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import com.autoloc.enums.RoleEmploye;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
}
