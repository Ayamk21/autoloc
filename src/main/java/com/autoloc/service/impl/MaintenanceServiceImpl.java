package com.autoloc.service.impl;

import com.autoloc.entity.Maintenance;
import com.autoloc.repository.MaintenanceRepository;
import com.autoloc.service.MaintenanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Maintenance introuvable avec l'id " + id));
    }

    @Override
    public Maintenance update(Long id, Maintenance maintenance) {
        if (!maintenanceRepository.existsById(id)) {
            throw new EntityNotFoundException("Maintenance introuvable avec l'id " + id);
        }
        maintenance.setIdMaintenance(id);
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new EntityNotFoundException("Maintenance introuvable avec l'id " + id);
        }
        maintenanceRepository.deleteById(id);
    }
}
