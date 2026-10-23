package com.autoloc.controller;

import com.autoloc.entity.Contrat;
import com.autoloc.service.ContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    // CREATE : POST /api/contrats
    @PostMapping
    public ResponseEntity<Contrat> create(@RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.create(contrat));
    }

    // READ (liste) : GET /api/contrats
    @GetMapping
    public ResponseEntity<List<Contrat>> getAll() {
        return ResponseEntity.ok(contratService.getAll());
    }

    // READ (un élément) : GET /api/contrats/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getById(id));
    }

    // UPDATE : PUT /api/contrats/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.update(id, contrat));
    }

    // DELETE : DELETE /api/contrats/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
