package com.autoloc.controller;

import com.autoloc.entity.Agence;
import com.autoloc.service.AgenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    // CREATE : POST /api/agences
    @PostMapping
    public ResponseEntity<Agence> create(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.create(agence));
    }

    // READ (liste) : GET /api/agences
    @GetMapping
    public ResponseEntity<List<Agence>> getAll() {
        return ResponseEntity.ok(agenceService.getAll());
    }

    // READ (un élément) : GET /api/agences/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        return ResponseEntity.ok(agenceService.getById(id));
    }

    // UPDATE : PUT /api/agences/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        return ResponseEntity.ok(agenceService.update(id, agence));
    }

    // DELETE : DELETE /api/agences/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
