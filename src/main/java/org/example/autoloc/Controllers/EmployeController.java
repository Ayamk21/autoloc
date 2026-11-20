package org.example.autoloc.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Employe;
import org.example.autoloc.services.IEmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employe")
@Tag(name = "gestion des employés", description = "Crud")
public class EmployeController {

    private final IEmployeService employeService;

    @Operation(summary = "ajouter un employé")
    @PostMapping("ajoute")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("update")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/getById/{idEmploye}")
    public Employe getEmployeById(@PathVariable Long idEmploye) {
        return employeService.consulterEmployeById(idEmploye);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public void deleteEmployeById(@PathVariable Long idEmploye) {
        employeService.supprimerEmployeById(idEmploye);
    }

    @Operation(summary = "désaffecter un employé de son agence")
    @PutMapping("/desaffecter/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @Operation(summary = "affecter un employé à une agence")
    @PutMapping("/affecter/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
