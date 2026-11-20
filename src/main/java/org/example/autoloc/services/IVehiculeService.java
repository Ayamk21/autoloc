package org.example.autoloc.services;

import org.example.autoloc.entities.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    Vehicule modifierVehicule(Vehicule vehicule);
    List<Vehicule> consulterVehicules();
    Vehicule consulterVehiculeById(long idVehicule);
    void supprimerVehiculeById(long idVehicule);

    // Scénario 3 : affectation / désaffectation d'un équipement à un véhicule (@ManyToMany)
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}
