package com.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Equipement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;
    private String libelle;

    @ManyToMany(mappedBy = "equipements")
    private List<Vehicule> vehicules = new ArrayList<>();
}
