package com.autoloc.service.impl;

import com.autoloc.entity.Vehicule;
import com.autoloc.repository.VehiculeRepository;
import com.autoloc.service.VehiculeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule getById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Vehicule introuvable avec l'id " + id));
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        if (!vehiculeRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicule introuvable avec l'id " + id);
        }
        vehicule.setIdVehicule(id);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicule introuvable avec l'id " + id);
        }
        vehiculeRepository.deleteById(id);
    }
}
