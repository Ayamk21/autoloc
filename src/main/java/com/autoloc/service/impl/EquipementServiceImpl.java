package com.autoloc.service.impl;

import com.autoloc.entity.Equipement;
import com.autoloc.repository.EquipementRepository;
import com.autoloc.service.EquipementService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement getById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Equipement introuvable avec l'id " + id));
    }

    @Override
    public Equipement update(Long id, Equipement equipement) {
        if (!equipementRepository.existsById(id)) {
            throw new EntityNotFoundException("Equipement introuvable avec l'id " + id);
        }
        equipement.setIdEquipement(id);
        return equipementRepository.save(equipement);
    }

    @Override
    public void delete(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new EntityNotFoundException("Equipement introuvable avec l'id " + id);
        }
        equipementRepository.deleteById(id);
    }
}
