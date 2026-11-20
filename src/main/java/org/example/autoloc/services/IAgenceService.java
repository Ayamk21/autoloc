package org.example.autoloc.services;

import org.example.autoloc.entities.Agence;
import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);
    Agence modifierAgence(Agence agence);
    List<Agence> consulterAgences();
    Agence consulterAgenceById(long idAgence);
    void supprimerAgenceById(long idAgence);

    // Scénario 2 : ajout d'une agence avec deux véhicules
    Agence ajouterAgenceEtAffecterVehicules(Agence agence);
}
