
package org.example.autoloc.Controllers;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Paiement;
import org.example.autoloc.services.IPaiementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {

    private IPaiementService paiementService;

    @PostMapping("/ajoute")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @GetMapping("/getAll")
    public List<Paiement> getAllPaiements() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/getById/{idPaiement}")
    public Paiement getPaiementById(@PathVariable Long idPaiement) {
        return paiementService.consulterPaiementById(idPaiement);
    }

    @PutMapping("/update")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deletePaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiementById(idPaiement);
    }
}
