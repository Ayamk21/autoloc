
package org.example.autoloc.Controllers;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Maintenance;
import org.example.autoloc.services.IMaintenanceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    private IMaintenanceService maintenanceService;

    @PostMapping("/ajoute")
    public Maintenance ajouterMaintenance(
            @RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @GetMapping("/getAll")
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/getById/{idMaintenance}")
    public Maintenance getMaintenanceById(
            @PathVariable Long idMaintenance) {
        return maintenanceService.consulterMaintenanceById(idMaintenance);
    }

    @PutMapping("/update")
    public Maintenance updateMaintenance(
            @RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @DeleteMapping("/delete/{idMaintenance}")
    public void deleteMaintenance(
            @PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenanceById(idMaintenance);
    }
}
