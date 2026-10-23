package com.autoloc.controller;

import com.autoloc.entity.Paiement;
import com.autoloc.service.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    // CREATE : POST /api/paiements
    @PostMapping
    public ResponseEntity<Paiement> create(@RequestBody Paiement paiement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.create(paiement));
    }

    // READ (liste) : GET /api/paiements
    @GetMapping
    public ResponseEntity<List<Paiement>> getAll() {
        return ResponseEntity.ok(paiementService.getAll());
    }

    // READ (un élément) : GET /api/paiements/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paiementService.getById(id));
    }

    // UPDATE : PUT /api/paiements/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        return ResponseEntity.ok(paiementService.update(id, paiement));
    }

    // DELETE : DELETE /api/paiements/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
