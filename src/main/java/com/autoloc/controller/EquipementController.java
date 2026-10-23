package com.autoloc.controller;

import com.autoloc.entity.Equipement;
import com.autoloc.service.EquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    private final EquipementService equipementService;

    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    // CREATE : POST /api/equipements
    @PostMapping
    public ResponseEntity<Equipement> create(@RequestBody Equipement equipement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipementService.create(equipement));
    }

    // READ (liste) : GET /api/equipements
    @GetMapping
    public ResponseEntity<List<Equipement>> getAll() {
        return ResponseEntity.ok(equipementService.getAll());
    }

    // READ (un élément) : GET /api/equipements/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(equipementService.getById(id));
    }

    // UPDATE : PUT /api/equipements/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement equipement) {
        return ResponseEntity.ok(equipementService.update(id, equipement));
    }

    // DELETE : DELETE /api/equipements/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
