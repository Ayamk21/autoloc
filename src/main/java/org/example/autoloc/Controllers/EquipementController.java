
package org.example.autoloc.Controllers;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Equipement;
import org.example.autoloc.services.IEquipementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {

    private IEquipementService equipementService;

    @PostMapping("/ajoute")
    public Equipement ajouterEquipement(
            @RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @GetMapping("/getAll")
    public List<Equipement> getAllEquipements() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/getById/{idEquipement}")
    public Equipement getEquipementById(
            @PathVariable Long idEquipement) {
        return equipementService.consulterEquipementById(idEquipement);
    }

    @PutMapping("/update")
    public Equipement updateEquipement(
            @RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping("/delete/{idEquipement}")
    public void deleteEquipement(
            @PathVariable Long idEquipement) {
        equipementService.supprimerEquipementById(idEquipement);
    }
}
