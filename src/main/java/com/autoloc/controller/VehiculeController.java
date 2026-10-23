package com.autoloc.controller;

import com.autoloc.entity.Vehicule;
import com.autoloc.service.VehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    // CREATE : POST /api/vehicules
    @PostMapping
    public ResponseEntity<Vehicule> create(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.create(vehicule));
    }

    // READ (liste) : GET /api/vehicules
    @GetMapping
    public ResponseEntity<List<Vehicule>> getAll() {
        return ResponseEntity.ok(vehiculeService.getAll());
    }

    // READ (un élément) : GET /api/vehicules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.getById(id));
    }

    // UPDATE : PUT /api/vehicules/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return ResponseEntity.ok(vehiculeService.update(id, vehicule));
    }

    // DELETE : DELETE /api/vehicules/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
