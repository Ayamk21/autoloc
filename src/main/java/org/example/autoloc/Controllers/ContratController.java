package org.example.autoloc.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Contrat;
import org.example.autoloc.services.IContratService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("contrat")
@Tag(name="gestion de contrats",description = "Crud")
public class ContratController {
    private final IContratService contratService;
    @Operation(summary = "ajouter un contrat")
    @PostMapping("ajoute")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }
    @PutMapping("update")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }
    @GetMapping
    public List<Contrat> getall() {
        return contratService.consulterContrats();
    }
    @GetMapping("/getById/{idContrat}")
    public Contrat getContratById(@PathVariable Long idContrat){
        return contratService.consulterContratById(idContrat);
    }
    @DeleteMapping("/deleteById/{idContrat}")
    public void deleteContratById(@PathVariable Long idContrat) {
        contratService.supprimerContratById(idContrat);
    }
}
