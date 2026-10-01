package com.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Vehicule> vehicules = new ArrayList<>();
}
