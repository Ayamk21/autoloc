package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Equipement;
import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.repositories.EquipementRepository;
import org.example.autoloc.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> consulterVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule consulterVehiculeById(long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public void supprimerVehiculeById(long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    /**
     * Scénario 3 (départ) : l'agent affecte le siège bébé (équipement existant)
     * au véhicule existant. Vehicule est le côté propriétaire de la relation
     * @ManyToMany (il porte @JoinTable "vehicule_equipement"), donc on ajoute
     * l'équipement dans la liste du véhicule puis on sauvegarde le véhicule.
     */
    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new IllegalArgumentException("Équipement introuvable : " + idEquipement));

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
            equipement.getVehicules().add(vehicule);   // cohérence côté inverse (en mémoire)
        }
        return vehiculeRepository.save(vehicule);
    }

    /**
     * Scénario 3 (retour) : l'agent désaffecte le siège bébé du véhicule.
     * On retire l'équipement de la liste du véhicule (côté propriétaire)
     * ce qui supprime la ligne dans la table d'association.
     */
    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new IllegalArgumentException("Équipement introuvable : " + idEquipement));

        vehicule.getEquipements().remove(equipement);
        equipement.getVehicules().remove(vehicule);
        return vehiculeRepository.save(vehicule);
    }
}
