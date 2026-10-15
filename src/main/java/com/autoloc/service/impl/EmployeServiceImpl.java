package com.autoloc.service.impl;

import com.autoloc.entity.Employe;
import com.autoloc.repository.EmployeRepository;
import com.autoloc.service.EmployeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Employe introuvable avec l'id " + id));
    }

    @Override
    public Employe update(Long id, Employe employe) {
        if (!employeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employe introuvable avec l'id " + id);
        }
        employe.setIdEmploye(id);
        return employeRepository.save(employe);
    }

    @Override
    public void delete(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employe introuvable avec l'id " + id);
        }
        employeRepository.deleteById(id);
    }
}
