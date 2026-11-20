package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Agence;
import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.repositories.AgenceRepository;
import org.example.autoloc.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IAgenceServiceImp implements IAgenceService {

   /* @Autowired*/
    private AgenceRepository agenceRepository;
    private VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> consulterAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence consulterAgenceById(long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public void supprimerAgenceById(long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    /**
     * Scénario 2 : le service de gestion crée une nouvelle agence (ex. Sousse)
     * et y ajoute deux nouveaux véhicules.
     * 1) on enregistre l'agence
     * 2) on enregistre chaque véhicule en l'affectant à l'agence
     *    (Vehicule est le côté propriétaire de la relation : c'est lui qui porte agence_id)
     */
    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules = agence.getVehicules() != null ? agence.getVehicules() : new ArrayList<>();

        agence.setVehicules(new ArrayList<>());
        Agence agenceEnregistree = agenceRepository.save(agence);

        for (Vehicule vehicule : vehicules) {
            vehicule.setAgence(agenceEnregistree);                     // affectation côté propriétaire
            Vehicule vehiculeEnregistre = vehiculeRepository.save(vehicule);
            agenceEnregistree.getVehicules().add(vehiculeEnregistre);  // mise à jour côté inverse
        }

        return agenceEnregistree;
    }
}
