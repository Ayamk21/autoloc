package org.example.autoloc.services;

import org.example.autoloc.entities.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    Maintenance modifierMaintenance(Maintenance maintenance);
    List<Maintenance> consulterMaintenances();
    Maintenance consulterMaintenanceById(long idaintenance);
    void supprimerMaintenanceById(long idaintenance);
}
