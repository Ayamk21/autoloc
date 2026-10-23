package com.autoloc.controller;

import com.autoloc.entity.Employe;
import com.autoloc.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    // CREATE : POST /api/employes
    @PostMapping
    public ResponseEntity<Employe> create(@RequestBody Employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.create(employe));
    }

    // READ (liste) : GET /api/employes
    @GetMapping
    public ResponseEntity<List<Employe>> getAll() {
        return ResponseEntity.ok(employeService.getAll());
    }

    // READ (un élément) : GET /api/employes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeService.getById(id));
    }

    // UPDATE : PUT /api/employes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        return ResponseEntity.ok(employeService.update(id, employe));
    }

    // DELETE : DELETE /api/employes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
